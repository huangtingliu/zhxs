package cn.zhxs.modules.pension.memberrepastpackage.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.pension.memberrepastpackage.mapper.MemberRepastPackageMapper;
import cn.zhxs.modules.pension.memberrepastpackage.entity.MemberRepastPackage;
import cn.zhxs.modules.pension.memberrepastpackage.service.IMemberRepastPackageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 会员餐饮套餐信息
 * @Description: 会员餐饮套餐信息
 * @author huangtl
 * @date 2018-09-09 21:23:25
 * @version V1.0   
 *
 */
@Transactional
@Service("memberRepastPackageService")
public class MemberRepastPackageServiceImpl  extends CommonServiceImpl<MemberRepastPackageMapper,MemberRepastPackage> implements  IMemberRepastPackageService {

}
