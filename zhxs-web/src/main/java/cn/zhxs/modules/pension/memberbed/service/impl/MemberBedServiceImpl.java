package cn.zhxs.modules.pension.memberbed.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.memberbed.mapper.MemberBedMapper;
import cn.zhxs.modules.pension.memberbed.entity.MemberBed;
import cn.zhxs.modules.pension.memberbed.service.IMemberBedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 会员床位信息
 * @Description: 会员床位信息
 * @author huangtl
 * @date 2018-09-09 21:45:18
 * @version V1.0   
 *
 */
@Transactional
@Service("memberBedService")
public class MemberBedServiceImpl  extends CommonServiceImpl<MemberBedMapper,MemberBed> implements  IMemberBedService {

}
