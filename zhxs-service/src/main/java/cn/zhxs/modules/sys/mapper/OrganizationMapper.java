package cn.zhxs.modules.sys.mapper;

import cn.zhxs.core.common.mapper.BaseTreeMapper;
import cn.zhxs.modules.sys.entity.Organization;

import java.util.List;

public interface OrganizationMapper extends BaseTreeMapper<Organization> {
	
	/**
	 * 
	 * @title: findListByUserId
	 * @description: 通过用户查找组织机构
	 * @param userId
	 * @return
	 * @return: List<Organization>
	 */
	List<Organization> findListByUserId(String userId);
}