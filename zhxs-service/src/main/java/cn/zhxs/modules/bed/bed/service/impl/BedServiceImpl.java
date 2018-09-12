package cn.zhxs.modules.bed.bed.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.bed.bed.mapper.BedMapper;
import cn.zhxs.modules.bed.bed.entity.Bed;
import cn.zhxs.modules.bed.bed.service.IBedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 床位
 * @Description: 床位
 * @author huangtl
 * @date 2018-09-02 18:43:23
 * @version V1.0   
 *
 */
@Transactional
@Service("bedService")
public class BedServiceImpl  extends CommonServiceImpl<BedMapper,Bed> implements  IBedService {

}
