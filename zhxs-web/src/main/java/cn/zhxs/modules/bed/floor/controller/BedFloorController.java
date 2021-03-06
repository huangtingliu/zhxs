package cn.zhxs.modules.bed.floor.controller;

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
import cn.zhxs.modules.bed.house.entity.BedHouse;
import cn.zhxs.modules.bed.house.service.IBedHouseService;
import cn.zhxs.modules.bed.room.entity.BedRoom;
import cn.zhxs.modules.bed.room.service.IBedRoomService;
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
import cn.zhxs.modules.bed.floor.entity.BedFloor;
import cn.zhxs.modules.bed.floor.service.IBedFloorService;

/**   
 * @Title: 楼层
 * @Description: 楼层
 * @author huangtl
 * @date 2018-09-02 18:41:57
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/floor/bedfloor")
@RequiresPathPermission("floor:bedfloor")
public class BedFloorController extends BaseBeanController<BedFloor> {

    @Autowired
    protected IBedFloorService bedFloorService;
    @Autowired
    protected IBedHouseService bedHouseService;
    @Autowired
    protected IBedRoomService bedRoomService;

    public BedFloor get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return bedFloorService.selectById(id);
        } else {
            return newModel();
        }
    }

    /**
     * 生成房间编号
     * @param floor
     * @param roomIndex
     * @return
     */
    private String generateRoomNo(BedFloor floor,int roomIndex){
        //房间编号为楼层编号+（01---XX）
        String roomNo= roomIndex<10?(floor.getFloorNo()+"0"+roomIndex):(""+floor.getFloorNo()+roomIndex);
        return roomNo;
    }

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        String houseName = "";
        Wrapper<BedHouse> wrapper = new EntityWrapper<>();
        List<BedHouse> bedHouses = bedHouseService.selectList(wrapper);
        for (BedHouse bedHouse : bedHouses) {
            houseName+=bedHouse.getId()+":"+bedHouse.getHouseName()+";";
        }
        model.addAttribute("houseName",houseName);
        return display("list");
    }

    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    //@PageableDefaults(sort = "id=desc")
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<BedFloor> entityWrapper = new EntityWrapper<BedFloor>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        entityWrapper.orderBy("create_date",false);
        entityWrapper.orderBy("floor_no",true);
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageJson<BedFloor> pagejson = new PageJson<BedFloor>(bedFloorService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        Wrapper<BedHouse> wrapper = new EntityWrapper<>();
        List<BedHouse> bedHouses = bedHouseService.selectList(wrapper);
        model.addAttribute("bedHouses", bedHouses);
        return display("edit");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") BedFloor bedFloor, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        bedFloor.setCreateDate(DateUtils.getDateTime());
        bedFloor.setCreateBy(UserUtils.getUser());
        String houseId = bedFloor.getHouseId();
        BedHouse bedHouse = bedHouseService.selectById(houseId);
        bedHouse.setFloorNumber(bedHouse.getFloorNumber()+1);
        bedHouseService.updateById(bedHouse);
        return doSave(bedFloor, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        BedFloor bedFloor = get(id);
        model.addAttribute("data", bedFloor);
        Wrapper<BedHouse> wrapper = new EntityWrapper<>();
        List<BedHouse> bedHouses = bedHouseService.selectList(wrapper);
        model.addAttribute("bedHouses", bedHouses);
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") BedFloor bedFloor, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        User user = UserUtils.getUser();
        String dateTime = DateUtils.getDateTime();
        bedFloor.setUpdateDate(dateTime);
        bedFloor.setUpdateBy(user);

        BedFloor floor = get(bedFloor.getId());
        if(floor.getRoomNumber()<bedFloor.getRoomNumber()){
            insertDefaultRoom(floor.getRoomNumber()+1,bedFloor);
        }else if(floor.getRoomNumber()>bedFloor.getRoomNumber()){
            delDefaultRoom(bedFloor.getRoomNumber()+1,floor);
        }
        return doSave(bedFloor, request, response, result);
    }

    /**
     * 添加默认的房间
     * //1、根据楼层的编号、房间数自动生成房间列表，房间编号为楼层编号+（01---XX）
     * //2、楼层房间数修改时，自动增减相应的房间数目
     * //3、楼层编号变化时，房间编号重新生成
     * @param start 起始房间数
     * @param bedFloor 楼层信息
     */
    private void insertDefaultRoom(int start,BedFloor bedFloor){
        User user = UserUtils.getUser();
        String dateTime = DateUtils.getDateTime();
        List<BedRoom> list = new ArrayList<BedRoom>();
        while (start<=bedFloor.getRoomNumber()){
            BedRoom bedRoom = new BedRoom();
            bedRoom.setCreateBy(user);
            bedRoom.setCreateDate(dateTime);
            bedRoom.setFloorId(bedFloor.getId());
            //房间编号为楼层编号+（01---XX）
            String roomNo= generateRoomNo(bedFloor,start);
            bedRoom.setRoomNo(roomNo);
            bedRoom.setRoomNoText(roomNo);
            list.add(bedRoom);
            start++;
        }
        bedRoomService.insertBatch(list);
    }

    /**
     * 删除楼层的房间
     * @param start 开始删除的房间索引
     * @param bedFloor 楼层
     */
    private void delDefaultRoom(int start,BedFloor bedFloor){
        Wrapper<BedRoom> roomWrapper = new EntityWrapper<BedRoom>();
        roomWrapper.eq("floor_id",bedFloor.getId());
        roomWrapper.ge("room_no",generateRoomNo(bedFloor,start));

        List<BedRoom> bedRooms = bedRoomService.selectList(roomWrapper);
        if(bedRooms.size()>0) {
            List<String> roomIds = new ArrayList<>();
            for (BedRoom bedRoom : bedRooms) {
                roomIds.add(bedRoom.getId());
            }
            bedRoomService.deleteBatchIds(roomIds);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(BedFloor bedFloor, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(bedFloor, result)) {
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
            if (StringUtils.isEmpty(bedFloor.getId())) {
                bedFloorService.insert(bedFloor);
            } else {
                bedFloorService.insertOrUpdate(bedFloor);
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
            bedFloorService.deleteById(id);
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
            bedFloorService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        BedFloor bedFloor = get(id);
        model.addAttribute("data", bedFloor);
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<BedFloor> entityWrapper = new EntityWrapper<BedFloor>(entityClass);
            valid = bedFloorService.doValid(duplicateValid,entityWrapper);
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
