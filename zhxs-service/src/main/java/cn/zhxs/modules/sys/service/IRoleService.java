package cn.zhxs.modules.sys.service;

import cn.zhxs.core.common.service.ICommonService;
import cn.zhxs.modules.sys.entity.Role;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:15
 * @version V1.0
 *
 */
public interface IRoleService extends ICommonService<Role> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Role> findListByUserId(String userid);
}
