package cn.zhxs.modules.sys.service;

import cn.zhxs.core.common.service.ITreeCommonService;
import cn.zhxs.modules.sys.entity.Menu;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:32
 * @version V1.0
 *
 */
public interface IMenuService extends ITreeCommonService<Menu, String> {

	/**
	 * 通过用户ID查找菜单
	 * 
	 * @return
	 */
	List<Menu> findMenuByUserId(String userId);

	/**
	 * 通过角色查找菜单
	 * 
	 * @return
	 */
	List<Menu> findMenuByRoleId(String roleId);
}
