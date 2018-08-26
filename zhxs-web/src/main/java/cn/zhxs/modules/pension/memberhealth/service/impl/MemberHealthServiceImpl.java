package cn.zhxs.modules.pension.memberhealth.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.memberhealth.mapper.MemberHealthMapper;
import cn.zhxs.modules.pension.memberhealth.entity.MemberHealth;
import cn.zhxs.modules.pension.memberhealth.service.IMemberHealthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: member_health
 * @Description: member_health
 * @author huangtl
 * @date 2018-08-26 18:07:38
 * @version V1.0   
 *
 */
@Transactional
@Service("memberHealthService")
public class MemberHealthServiceImpl  extends CommonServiceImpl<MemberHealthMapper,MemberHealth> implements  IMemberHealthService {

}
