package cn.zhxs.modules.bed.house.controller;

import cn.zhxs.core.common.data.DuplicateValid;
import cn.zhxs.core.common.service.ICommonService;
import cn.zhxs.core.model.AjaxJson;
import cn.zhxs.core.model.PageJson;
import cn.zhxs.core.model.ValidJson;
import cn.zhxs.core.query.annotation.PageableDefaults;
import cn.zhxs.core.query.data.PropertyPreFilterable;
import cn.zhxs.core.query.data.Queryable;
import cn.zhxs.core.query.utils.QueryableConvertUtils;
import cn.zhxs.core.query.wrapper.EntityWrapper;
import cn.zhxs.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.zhxs.core.utils.*;
import cn.zhxs.modules.bed.bed.entity.Bed;
import cn.zhxs.modules.bed.floor.entity.BedFloor;
import cn.zhxs.modules.bed.floor.service.IBedFloorService;
import cn.zhxs.modules.sys.entity.User;
import cn.zhxs.modules.sys.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import cn.zhxs.modules.bed.house.entity.BedHouse;
import cn.zhxs.modules.bed.house.service.IBedHouseService;
/**   
 * @Title: 楼宇
 * @Description: 楼宇
 * @author huangtl
 * @date 2018-09-02 18:37:28
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/house/bedhouse")
@RequiresPathPermission("house:bedhouse")
public class BedHouseController extends BaseBeanController<BedHouse> {

    @Autowired
    protected IBedHouseService bedHouseService;
    @Autowired
    protected IBedFloorService bedFloorService;

    public BedHouse get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return bedHouseService.selectById(id);
        } else {
            return newModel();
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson get(String id, HttpServletRequest request,
                        HttpServletResponse response) {
        BedHouse bedHouse = get(id);
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("查询成功");
        ajaxJson.setData(bedHouse);
        return ajaxJson;
    }

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return display("list");
    }

    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    //@PageableDefaults(sort = "id=desc")
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<BedHouse> entityWrapper = new EntityWrapper<BedHouse>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        entityWrapper.orderBy("create_time",false);
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<BedHouse> pagejson = new PageJson<BedHouse>(bedHouseService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        return display("edit");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") BedHouse bedHouse, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        bedHouse.setCreateTime(DateUtils.getDateTime());
        bedHouse.setCreateBy(UserUtils.getUser());

        return doSave(bedHouse, request, response, result);
    }

    /**
     * 添加默认的楼层
     * @param start 起始层
     * @param end 结束层
     * @param houseId 楼宇id
     */
    private void insertDefaultFloor(int start,int end,String houseId){
        User user = UserUtils.getUser();
        String dateTime = DateUtils.getDateTime();
        List<BedFloor> list = new ArrayList<BedFloor>();
        while (start<=end){
            BedFloor floor = new BedFloor();
            floor.setFloor(start+"层");
            floor.setFloorNo(start);
            floor.setHouseId(houseId);
            floor.setCreateDate(dateTime);
            floor.setCreateBy(user);
            list.add(floor);
            start++;
        }
        bedFloorService.insertBatch(list);
    }

    /**
     * 删除楼层
     * @param start 起始层,删除大于该层的楼层
     * @param houseId 楼宇id
     */
    private void deleteFloors(int start,String houseId){
        Wrapper<BedFloor> floorWrapper = new EntityWrapper<>();
        floorWrapper.eq("house_id",houseId);
        floorWrapper.gt("floor_no",start);
        List<BedFloor> bedFloors = bedFloorService.selectList(floorWrapper);

        if(bedFloors.size()>0) {
            List<String> floorIds = new ArrayList<>();
            for (BedFloor bedFloor : bedFloors) {
                floorIds.add(bedFloor.getId());
            }
            bedFloorService.deleteBatchIds(floorIds);
        }
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        BedHouse bedHouse = get(id);
        model.addAttribute("data", bedHouse);
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") BedHouse bedHouse, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        //楼层修改时自动增加或减少相应的层数
        Integer floorNumber = bedHouse.getFloorNumber();
        BedHouse dbHouse = bedHouseService.selectById(bedHouse.getId());
        if(floorNumber>dbHouse.getFloorNumber()){
            //如果楼层数大于已有的数据,增加默认的层
            insertDefaultFloor(dbHouse.getFloorNumber()+1,floorNumber,bedHouse.getId());
        }else if(floorNumber<dbHouse.getFloorNumber()){
            //如果楼层数小于于已有的数据,删除多余的楼层
            deleteFloors(floorNumber,bedHouse.getId());
        }
        return doSave(bedHouse, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(BedHouse bedHouse, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(bedHouse, result)) {
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
            if (StringUtils.isEmpty(bedHouse.getId())) {
                bedHouseService.insert(bedHouse);
                //根据楼层数生成默认楼层
                insertDefaultFloor(1,bedHouse.getFloorNumber(),bedHouse.getId());
            } else {
                bedHouseService.insertOrUpdate(bedHouse);
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
            bedHouseService.deleteById(id);
            deleteFloors(0,id);//删除楼层
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
            bedHouseService.deleteBatchIds(idList);
            for (String id : idList) {
                deleteFloors(0,id);//删除楼层
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        BedHouse bedHouse = get(id);
        model.addAttribute("data", bedHouse);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<BedHouse> entityWrapper = new EntityWrapper<BedHouse>(entityClass);
            valid = bedHouseService.doValid(duplicateValid,entityWrapper);
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

