package cn.zhxs.modules.repast.repastpackage.controller;

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
import cn.zhxs.core.utils.DateUtils;
import cn.zhxs.core.utils.ObjectUtils;
import cn.zhxs.core.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import cn.zhxs.modules.repast.repastpackage.entity.RepastPackage;
import cn.zhxs.modules.repast.repastpackage.service.IRepastPackageService;
/**   
 * @Title: 饮食套餐
 * @Description: 饮食套餐
 * @author huangtl
 * @date 2018-09-02 14:59:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/repastpackage/repastpackage")
@RequiresPathPermission("repastpackage:repastpackage")
public class RepastPackageController extends BaseBeanController<RepastPackage> {

    @Autowired
    protected IRepastPackageService repastPackageService;
    public RepastPackage get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return repastPackageService.selectById(id);
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
        EntityWrapper<RepastPackage> entityWrapper = new EntityWrapper<RepastPackage>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<RepastPackage> pagejson = new PageJson<RepastPackage>(repastPackageService.list(queryable,entityWrapper));
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
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") RepastPackage repastPackage, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(repastPackage, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        RepastPackage repastPackage = get(id);
        model.addAttribute("data", repastPackage);
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") RepastPackage repastPackage, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(repastPackage, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(RepastPackage repastPackage, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(repastPackage, result)) {
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

            repastPackage.setCreateTime(DateUtils.getDateTime());
            if (StringUtils.isEmpty(repastPackage.getId())) {
                repastPackageService.insert(repastPackage);
            } else {
                repastPackageService.insertOrUpdate(repastPackage);
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
            repastPackageService.deleteById(id);
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
            repastPackageService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        RepastPackage repastPackage = get(id);
        model.addAttribute("data", repastPackage);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<RepastPackage> entityWrapper = new EntityWrapper<RepastPackage>(entityClass);
            valid = repastPackageService.doValid(duplicateValid,entityWrapper);
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

