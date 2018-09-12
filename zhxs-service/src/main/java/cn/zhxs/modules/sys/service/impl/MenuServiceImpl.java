package cn.zhxs.modules.sys.service.impl;

import cn.zhxs.core.common.service.impl.TreeCommonServiceImpl;
import cn.zhxs.modules.sys.entity.Menu;
import cn.zhxs.modules.sys.mapper.MenuMapper;
import cn.zhxs.modules.sys.service.IMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper, Menu, String> implements IMenuService {

	@Override
	public List<Menu> findMenuByUserId(String userId) {
		return baseMapper.findMenuByUserId(userId);
	}

	@Override
	public List<Menu> findMenuByRoleId(String roleId) {
		return baseMapper.findMenuByRoleId(roleId);
	}

}
