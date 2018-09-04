package cn.zhxs.modules.repast.food.controller;

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
import cn.zhxs.modules.repast.foodtype.entity.RepastFoodType;
import cn.zhxs.modules.repast.foodtype.service.IRepastFoodTypeService;
import cn.zhxs.modules.sys.utils.UserUtils;
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
import java.util.Date;
import java.util.List;
import cn.zhxs.modules.repast.food.entity.RepastFood;
import cn.zhxs.modules.repast.food.service.IRepastFoodService;

/**   
 * @Title: 菜品表
 * @Description: 菜品表
 * @author huangtl
 * @date 2018-09-02 15:50:46
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/food/repastfood")
@RequiresPathPermission("food:repastfood")
public class RepastFoodController extends BaseBeanController<RepastFood> {

    @Autowired
    protected IRepastFoodService repastFoodService;
    @Autowired
    protected IRepastFoodTypeService repastFoodTypeService;

    public RepastFood get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return repastFoodService.selectById(id);
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
    //@PageableDefaults(sort = "")
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<RepastFood> entityWrapper = new EntityWrapper<RepastFood>(entityClass);
        propertyPreFilterable.addQueryProperty("t.id");
        entityWrapper.orderBy("t.create_date",false);
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<RepastFood> pagejson = new PageJson<RepastFood>(repastFoodService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        List<RepastFoodType> foodType = repastFoodTypeService.selectList(new EntityWrapper<RepastFoodType>());
        model.addAttribute("typeId", foodType);
        return display("edit");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") RepastFood repastFood, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        repastFood.setCreateBy(UserUtils.getUser());
        repastFood.setCreateDate(DateUtils.getDate());
        return doSave(repastFood, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        RepastFood repastFood = get(id);
        model.addAttribute("data", repastFood);
        List<RepastFoodType> foodType = repastFoodTypeService.selectList(new EntityWrapper<RepastFoodType>());
        model.addAttribute("typeId", foodType);
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") RepastFood repastFood, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        repastFood.setUpdateBy(UserUtils.getUser());
        repastFood.setUpdateDate(DateUtils.getDate());
        return doSave(repastFood, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(RepastFood repastFood, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(repastFood, result)) {
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
            if (StringUtils.isEmpty(repastFood.getId())) {
                repastFoodService.insert(repastFood);
            } else {
                repastFoodService.insertOrUpdate(repastFood);
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
            repastFoodService.deleteById(id);
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
            repastFoodService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        RepastFood repastFood = get(id);
        model.addAttribute("data", repastFood);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<RepastFood> entityWrapper = new EntityWrapper<RepastFood>(entityClass);
            valid = repastFoodService.doValid(duplicateValid,entityWrapper);
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
