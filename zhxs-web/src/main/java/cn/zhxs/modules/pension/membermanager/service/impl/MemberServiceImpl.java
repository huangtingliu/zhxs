package cn.zhxs.modules.pension.membermanager.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.membermanager.mapper.MemberMapper;
import cn.zhxs.modules.pension.membermanager.entity.Member;
import cn.zhxs.modules.pension.membermanager.service.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: member
 * @Description: 老人会员基础信息
 * @author huangtl
 * @date 2018-08-17 17:50:10
 * @version V1.0   
 *
 */
@Transactional
@Service("memberService")
public class MemberServiceImpl  extends CommonServiceImpl<MemberMapper,Member> implements  IMemberService {

}
