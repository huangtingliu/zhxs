package cn.zhxs.modules.bed.room.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.bed.bed.entity.Bed;
import cn.zhxs.modules.bed.bed.service.IBedService;
import cn.zhxs.modules.bed.room.mapper.BedRoomMapper;
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
 * @Title: 房间
 * @Description: 房间
 * @author huangtl
 * @date 2018-09-02 18:43:15
 * @version V1.0   
 *
 */
@Transactional
@Service("bedRoomService")
public class BedRoomServiceImpl  extends CommonServiceImpl<BedRoomMapper,BedRoom> implements  IBedRoomService {

    @Autowired
    protected IBedService bedService;

    /**
     * 删除楼层时，相应楼层的房间和床位数据一并删除
     * @param idList
     * @return
     */
    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {

        for (Serializable id : idList) {
            //查询所有该房间床位
            Wrapper<Bed> bedWrapper = new EntityWrapper<Bed>();
            bedWrapper.eq("room_id",id);
            List<Bed> bedList = bedService.selectList(bedWrapper);
            List<String> bedIdList =new ArrayList<>();
            for (Bed bed : bedList) {
                bedIdList.add(bed.getId());
            }
            //删除该房间所有床位
            bedService.deleteBatchIds(bedIdList);
        }
        return super.deleteBatchIds(idList);
    }
}
