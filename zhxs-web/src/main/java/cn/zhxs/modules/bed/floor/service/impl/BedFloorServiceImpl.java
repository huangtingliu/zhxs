package cn.zhxs.modules.bed.floor.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.bed.floor.mapper.BedFloorMapper;
import cn.zhxs.modules.bed.floor.entity.BedFloor;
import cn.zhxs.modules.bed.floor.service.IBedFloorService;
import cn.zhxs.modules.bed.room.entity.BedRoom;
import cn.zhxs.modules.bed.room.service.IBedRoomService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: 楼层
 * @Description: 楼层
 * @author huangtl
 * @date 2018-09-02 18:41:57
 * @version V1.0   
 *
 */
@Transactional
@Service("bedFloorService")
public class BedFloorServiceImpl  extends CommonServiceImpl<BedFloorMapper,BedFloor> implements  IBedFloorService {

    @Autowired
    protected IBedRoomService bedRoomService;

    /**
     * 删除楼层时，相应楼层的房间和床位数据一并删除
     * @param idList
     * @return
     */
    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {

        for (Serializable id : idList) {
            //查询所有该楼层房间
            Wrapper<BedRoom> roomWrapper = new EntityWrapper<BedRoom>();
            roomWrapper.eq("floor_id",id);
            List<BedRoom> roomList = bedRoomService.selectList(roomWrapper);
            if(roomList.size()>0){
                List<String> roomIdList =new ArrayList<>();
                for (BedRoom bedRoom : roomList) {
                    roomIdList.add(bedRoom.getId());
                }
                //删除该楼层所有房间，其中会删除该房间所有床位
                bedRoomService.deleteBatchIds(roomIdList);
            }
        }
        return super.deleteBatchIds(idList);
    }

}
