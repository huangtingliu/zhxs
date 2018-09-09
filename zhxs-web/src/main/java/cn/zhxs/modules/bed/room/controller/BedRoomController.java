package cn.zhxs.modules.bed.room.controller;

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
import cn.zhxs.modules.bed.bed.entity.Bed;
import cn.zhxs.modules.bed.bed.service.IBedService;
import cn.zhxs.modules.bed.floor.entity.BedFloor;
import cn.zhxs.modules.bed.floor.service.IBedFloorService;
import cn.zhxs.modules.bed.room.mapper.BedRoomMapper;
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
import java.util.ArrayList;
import java.util.List;
import cn.zhxs.modules.bed.room.entity.BedRoom;
import cn.zhxs.modules.bed.room.service.IBedRoomService;

/**   
 * @Title: 房间
 * @Description: 房间
 * @author huangtl
 * @date 2018-09-02 18:43:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/room/bedroom")
@RequiresPathPermission("room:bedroom")
public class BedRoomController extends BaseBeanController<BedRoom> {

    @Autowired
    protected IBedRoomService bedRoomService;
    @Autowired
    protected IBedService bedService;

    public BedRoom get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return bedRoomService.selectById(id);
        } else {
            return newModel();
        }
    }

    /**
     * 生成床位编号
     * 床位编号为房间编号+（01---XX）
     * @param bedRoom 房间号
     * @param bedIndex 床位序号
     * @return
     */
    private String generateBedNo(BedRoom bedRoom, int bedIndex) {
        return bedIndex<10?(bedRoom.getRoomNo()+"0"+bedIndex):(""+bedRoom.getRoomNo()+bedIndex);
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
        EntityWrapper<BedRoom> entityWrapper = new EntityWrapper<BedRoom>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<BedRoom> pagejson = new PageJson<BedRoom>(bedRoomService.list(queryable,entityWrapper));
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
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") BedRoom bedRoom, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(bedRoom, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        BedRoom bedRoom = get(id);
        model.addAttribute("data", bedRoom);
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") BedRoom bedRoom, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        bedRoom.setUpdateDate(DateUtils.getDateTime());
        BedRoom room = get(bedRoom.getId());
        if(room.getBedNumber()< bedRoom.getBedNumber()){
            insertDefaultBed(room.getBedNumber()+1,bedRoom);
        }else if(room.getBedNumber()>bedRoom.getBedNumber()){
            delDefaultBed(bedRoom.getBedNumber()+1,room);
        }
        return doSave(bedRoom, request, response, result);
    }

    /**
     * 添加默认的床位
     * 1、根据房间的编号、床位数自动生成床位列表，床位编号为房间编号+（01---XX）
     * 2、房间床位数修改时，自动增减相应的床位数目
     * 3、房间编号变化时，床位编号重新生成
     * @param start 起始床位序号
     * @param bedRoom 房间信息
     */
    private void insertDefaultBed(int start,BedRoom bedRoom){
        User user = UserUtils.getUser();
        String dateTime = DateUtils.getDateTime();
        List<Bed> list = new ArrayList<Bed>();
        while (start<=bedRoom.getBedNumber()){
            Bed bed = new Bed();
            bed.setCreateBy(user);
            bed.setCreateDate(dateTime);
            bed.setRoomId(bedRoom.getId());
            String bedNo= generateBedNo(bedRoom,start);
            bed.setBedNo(bedNo);
            bed.setBedNoText(bedNo);
            list.add(bed);
            start++;
        }
        bedService.insertBatch(list);
    }

    /**
     * 删除房间的床位
     * @param start 开始删除的床位序号
     * @param bedRoom 房间
     */
    private void delDefaultBed(int start,BedRoom bedRoom){
        Wrapper<Bed> bedWrapper = new EntityWrapper<Bed>();
        bedWrapper.eq("room_id",bedRoom.getId());
        bedWrapper.ge("bed_no",generateBedNo(bedRoom,start));

        List<Bed> beds = bedService.selectList(bedWrapper);
        if(beds.size()>0) {
            List<String> bedIds = new ArrayList<>();
            for (Bed bed : beds) {
                bedIds.add(bed.getId());
            }
            bedService.deleteBatchIds(bedIds);
        }
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(BedRoom bedRoom, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(bedRoom, result)) {
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
            if (StringUtils.isEmpty(bedRoom.getId())) {
                bedRoomService.insert(bedRoom);
            } else {
                bedRoomService.insertOrUpdate(bedRoom);
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
            bedRoomService.deleteById(id);
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
            bedRoomService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        BedRoom bedRoom = get(id);
        model.addAttribute("data", bedRoom);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<BedRoom> entityWrapper = new EntityWrapper<BedRoom>(entityClass);
            valid = bedRoomService.doValid(duplicateValid,entityWrapper);
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
