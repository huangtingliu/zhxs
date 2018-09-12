package cn.zhxs.modules.pension.nursing.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.nursing.mapper.MemberNursingMapper;
import cn.zhxs.modules.pension.nursing.entity.MemberNursing;
import cn.zhxs.modules.pension.nursing.service.IMemberNursingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: MemberNursing
 * @Description: 护理
 * @author huangtl
 * @date 2018-08-26 22:39:52
 * @version V1.0   
 *
 */
@Transactional
@Service("memberNursingService")
public class MemberNursingServiceImpl  extends CommonServiceImpl<MemberNursingMapper,MemberNursing> implements  IMemberNursingService {

}
