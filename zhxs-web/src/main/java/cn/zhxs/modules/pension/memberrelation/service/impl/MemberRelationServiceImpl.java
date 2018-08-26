package cn.zhxs.modules.pension.memberrelation.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.memberrelation.mapper.MemberRelationMapper;
import cn.zhxs.modules.pension.memberrelation.entity.MemberRelation;
import cn.zhxs.modules.pension.memberrelation.service.IMemberRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: member_relation
 * @Description: member_relation
 * @author huangtl
 * @date 2018-08-26 15:38:02
 * @version V1.0   
 *
 */
@Transactional
@Service("memberRelationService")
public class MemberRelationServiceImpl  extends CommonServiceImpl<MemberRelationMapper,MemberRelation> implements  IMemberRelationService {

}
