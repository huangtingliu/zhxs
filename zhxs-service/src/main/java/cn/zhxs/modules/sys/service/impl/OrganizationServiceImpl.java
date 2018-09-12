package cn.zhxs.modules.sys.service.impl;

import cn.zhxs.core.common.service.impl.TreeCommonServiceImpl;
import cn.zhxs.modules.sys.entity.Organization;
import cn.zhxs.modules.sys.mapper.OrganizationMapper;
import cn.zhxs.modules.sys.service.IOrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

}
