package cn.zhxs.modules.pension.membermanager.controller;

import cn.zhxs.core.common.data.DuplicateValid;
import cn.zhxs.core.model.AjaxJson;
import cn.zhxs.core.model.PageJson;
import cn.zhxs.core.model.ValidJson;
import cn.zhxs.core.query.annotation.PageableDefaults;
import cn.zhxs.core.query.data.PropertyPreFilterable;
import cn.zhxs.core.query.data.Queryable;
import cn.zhxs.core.query.utils.QueryableConvertUtils;
import cn.zhxs.core.query.wrapper.EntityWrapper;
import cn.zhxs.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.zhxs.core.utils.DateUtils;
import cn.zhxs.core.utils.ObjectUtils;
import cn.zhxs.core.utils.StringUtils;
import cn.zhxs.modules.pension.memberbed.entity.MemberBed;
import cn.zhxs.modules.pension.memberbed.service.IMemberBedService;
import cn.zhxs.modules.pension.memberhealth.entity.MemberHealth;
import cn.zhxs.modules.pension.memberhealth.service.IMemberHealthService;
import cn.zhxs.modules.pension.membermanager.entity.MemberRepastBed;
import cn.zhxs.modules.pension.memberrelation.entity.MemberRelation;
import cn.zhxs.modules.pension.memberrelation.service.IMemberRelationService;
import cn.zhxs.modules.pension.memberrepastpackage.entity.MemberRepastPackage;
import cn.zhxs.modules.pension.memberrepastpackage.service.IMemberRepastPackageService;
import cn.zhxs.modules.pension.nursing.entity.MemberNursing;
import cn.zhxs.modules.pension.nursing.service.IMemberNursingService;
import cn.zhxs.modules.repast.repastpackage.entity.RepastPackage;
import cn.zhxs.modules.repast.repastpackage.service.IRepastPackageService;
import cn.zhxs.modules.sys.entity.Organization;
import cn.zhxs.modules.sys.entity.User;
import cn.zhxs.modules.sys.service.IOrganizationService;
import cn.zhxs.modules.sys.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.xmlbeans.impl.jam.mutable.MMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import cn.zhxs.core.common.controller.BaseBeanController;
import cn.zhxs.core.security.shiro.authz.annotation.RequiresPathPermission;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import cn.zhxs.modules.pension.membermanager.entity.Member;
import cn.zhxs.modules.pension.membermanager.service.IMemberService;

/**   
 * @Title: member
 * @Description: 老人会员基础信息
 * @author huangtl
 * @date 2018-08-17 17:50:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/membermanager/member")
@RequiresPathPermission("membermanager:member")
public class MemberController extends BaseBeanController<Member> {

    @Autowired
    protected IMemberService memberService;
    @Autowired
    protected IMemberRelationService relationService;
    @Autowired
    protected IMemberHealthService healthService;
    @Autowired
    protected IMemberNursingService nursingService;
    @Autowired
    protected IOrganizationService organizationService;
    @Autowired
    protected IMemberRepastPackageService memberRepastPackageService;
    @Autowired
    protected IRepastPackageService repastPackageService;
    @Autowired
    protected IMemberBedService memberBedService;

    public Member get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return memberService.selectById(id);
        } else {
            return newModel();
        }
    }

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return display("list");
    }

    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    @PageableDefaults(sort = "id=desc")
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<Member> entityWrapper = new EntityWrapper<Member>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        entityWrapper.orderBy("update_time",false);
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<Member> pagejson = new PageJson<Member>(memberService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", member);
        }
        return display("check_in");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") Member member, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        member.setCreateTime(DateUtils.getDateTime());
        User user = UserUtils.getUser();
        List<Organization> orgs = organizationService.findListByUserId(user.getId());

        String orgId = "";
        for (Organization org : orgs) {
            orgId+=org.getId()+",";
        }
        if(orgs.size()>0){
            orgId = orgId.substring(0,orgId.length()-1);
        }
        member.setOrgId(orgId);
        member.setCreateUserId(user.getId());
        member.setCreateUserName(user.getRealname());
        return doSave(member, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        Member member = get(id);
        model.addAttribute("data", member);
        return display("edit");
    }

    @RequestMapping(value = "{id}/toCheckIn", method = RequestMethod.GET)
    public String checkIn(@PathVariable("id") String id,Integer step, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        //if(null == id){
        //    throw new RuntimeException("id不能为空");
        //}
        Member member = get(id);
        if(null!=step){
            member.setStep(step);
            memberService.insertOrUpdate(member);
        }else {
            step = member.getStep();
        }
        //基础信息登记
        if(step==1){
            model.addAttribute("data", member);
            return display("check_in");
        }
        //家属登记
        if(step==2){
            EntityWrapper entityWrapper = new EntityWrapper<MemberRelation>();
            entityWrapper.eq("member_id",member.getId());
            List<MemberRelation> relations = relationService.selectList(entityWrapper);
            MemberRelation memberRelation = new MemberRelation();
            memberRelation.setMemberId(member.getId());
            model.addAttribute("relation", memberRelation);
            model.addAttribute("relations", relations);
            return display("check_in_relation");
        }
        //健康登记
        if(step==3){
            Wrapper<MemberHealth> healthWrapper = new EntityWrapper<MemberHealth>();
            healthWrapper.eq("member_id",member.getId());
            MemberHealth health = healthService.selectOne(healthWrapper);
            if(health==null){
                health = new MemberHealth();
                health.setMemberId(member.getId());
            }
            model.addAttribute("health", health);
            return display("check_in_health");
        }
        //护理登记
        if(step==4){

            Wrapper<MemberNursing> nursingWrapper = new EntityWrapper<MemberNursing>();
            nursingWrapper.eq("member_id",member.getId());
            MemberNursing nursing = nursingService.selectOne(nursingWrapper);
            if(nursing==null){
                nursing = new MemberNursing();
                nursing.setMemberId(member.getId());
            }
            model.addAttribute("nursing", nursing);
            return display("check_in_nursing");
        }
        //餐饮套餐和床位登记
        if(step==5){
            MemberRepastBed memberRepastBed = new MemberRepastBed();
            memberRepastBed.setMemberId(member.getId());
            //餐饮信息
            Wrapper<MemberRepastPackage> repastMemberPackageWrapper = new EntityWrapper<MemberRepastPackage>();
            repastMemberPackageWrapper.eq("member_id",member.getId());
            MemberRepastPackage memberRepastPackage = memberRepastPackageService.selectOne(repastMemberPackageWrapper);
            if(memberRepastPackage==null){
                memberRepastPackage = new MemberRepastPackage();
                memberRepastPackage.setMemberId(member.getId());
            }else {
                memberRepastBed.setPackageId(memberRepastPackage.getId());
                memberRepastBed.setPackageDetail(memberRepastPackage.getPackageDetail());
                memberRepastBed.setPackagePrice(memberRepastPackage.getPrice());
            }
            //model.addAttribute("memberRepastPackage", memberRepastPackage);
            //床位
            Wrapper<MemberBed> bedWrapper = new EntityWrapper<MemberBed>();
            bedWrapper.eq("member_id",member.getId());
            MemberBed memberBed = memberBedService.selectOne(bedWrapper);
            if(memberBed==null){
                memberBed = new MemberBed();
                memberBed.setMemberId(member.getId());
            }else{
                memberRepastBed.setBedId(memberBed.getId());
                memberRepastBed.setRoomType(memberBed.getRoomType());
                memberRepastBed.setIsPrivate(memberBed.getIsPrivate());
                memberRepastBed.setBedType(memberBed.getBedType());
                memberRepastBed.setBedNo(memberBed.getBedNo());
                memberRepastBed.setBedPrice(memberBed.getBedPrice());
            }
            //model.addAttribute("memberBed", memberBed);
            model.addAttribute("memberRepastBed", memberRepastBed);

            Wrapper<RepastPackage> repastPackageWrapper = new EntityWrapper<RepastPackage>();
            List<RepastPackage> repastPackage = repastPackageService.selectList(repastPackageWrapper);
            model.addAttribute("repastPackage", repastPackage);

            return display("check_in_repast_bed");
        }
        if(step==6){
            return display("check_in");
        }
        if(step==7){
            return display("check_in");
        }
        return display("check_in");
    }

    /**
     * 保存家属
     */
    @RequestMapping(value = "checkInRelation", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson checkInRelation(Model model, @Valid @ModelAttribute("relation") MemberRelation relation, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {

        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        try {
            relationService.insert(relation);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    /**
     * 保存健康
     */
    @RequestMapping(value = "checkInHealth", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson checkInHealth(Model model, @Valid @ModelAttribute("health") MemberHealth health, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {

        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        try {
            healthService.insertOrUpdate(health);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    /**
     * 保存护理
     */
    @RequestMapping(value = "checkInNursing", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson checkInNursing(Model model, @Valid @ModelAttribute("nursing") MemberNursing nursing, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {

        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        try {
            nursingService.insertOrUpdate(nursing);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    /**
     * 保存餐饮床位
     */
    @RequestMapping(value = "checkInRepastBed", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson checkInRepastBed(Model model, @Valid @ModelAttribute("memberRepastBed") MemberRepastBed memberRepastBed, BindingResult result,
                                    HttpServletRequest request, HttpServletResponse response) {

        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        try {
            MemberBed memberBed = new MemberBed();
            memberBed.setId(memberRepastBed.getBedId());
            memberBed.setMemberId(memberRepastBed.getMemberId());
            memberBed.setRoomType(memberRepastBed.getRoomType());
            memberBed.setIsPrivate(memberRepastBed.getIsPrivate());
            memberBed.setBedType(memberRepastBed.getBedType());
            memberBed.setBedNo(memberRepastBed.getBedNo());
            memberBed.setBedPrice(memberRepastBed.getBedPrice());
            memberBedService.insertOrUpdate(memberBed);

            MemberRepastPackage memberRepastPackage = new MemberRepastPackage();
            memberRepastPackage.setId(memberRepastBed.getPackageId());
            memberRepastPackage.setMemberId(memberRepastBed.getMemberId());
            memberRepastPackage.setPackageDetail(memberRepastBed.getPackageDetail());
            memberRepastPackage.setPrice(memberRepastBed.getPackagePrice());
            memberRepastPackageService.insertOrUpdate(memberRepastPackage);

        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    @RequestMapping(value = "{id}/checkIn", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson checkIn(Model model, @Valid @ModelAttribute("data") Member member, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        member.setCreateTime(DateUtils.getDateTime());
        User user = UserUtils.getUser();
        member.setCreateUserId(user.getId());
        member.setCreateUserName(user.getRealname());
        if(member.getStep()<7) {
            member.setStep(member.getStep() + 1);
        }
        List<Organization> orgs = organizationService.findListByUserId(user.getId());

        String orgId = "";
        for (Organization org : orgs) {
            orgId+=org.getId()+",";
        }
        if(orgs.size()>0){
            orgId = orgId.substring(0,orgId.length()-1);
        }
        member.setOrgId(orgId);
        return doSave(member, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") Member member, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {

        return doSave(member, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(Member member, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        member.setUpdateTime(DateUtils.getDateTime());
        ajaxJson.success("保存成功");
        if (hasError(member, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                ajaxJson.fail(errorMsg);
            } else {
                ajaxJson.fail("保存失败");
            }
            return ajaxJson;
        }
        try {
            if (StringUtils.isEmpty(member.getId())) {
                memberService.insert(member);
            } else {
                memberService.insertOrUpdate(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson delete(@PathVariable("id") String id) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            memberService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            memberService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        Member member = get(id);
        model.addAttribute("data", member);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<Member> entityWrapper = new EntityWrapper<Member>(entityClass);
            valid = memberService.doValid(duplicateValid,entityWrapper);
            if (valid) {
                validJson.setStatus("y");
                validJson.setInfo("验证通过!");
            } else {
                validJson.setStatus("n");
                if (!StringUtils.isEmpty(duplicateValid.getErrorMsg())) {
                    validJson.setInfo(duplicateValid.getErrorMsg());
                } else {
                    validJson.setInfo("当前信息重复!");
                }
            }
        } catch (Exception e) {
            validJson.setStatus("n");
            validJson.setInfo("验证异常，请检查字段是否正确!");
        }
        return validJson;
    }
}
