package cn.zhxs.modules.sys.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.sys.entity.RoleMenu;
import cn.zhxs.modules.sys.mapper.RoleMenuMapper;
import cn.zhxs.modules.sys.service.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
