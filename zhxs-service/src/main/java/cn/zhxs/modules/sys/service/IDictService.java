package cn.zhxs.modules.sys.service;


import cn.zhxs.core.common.service.ICommonService;
import cn.zhxs.modules.sys.entity.Dict;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2017-02-09 09:05:29
 * @version V1.0
 *
 */
public interface IDictService extends ICommonService<Dict> {
    public List<Dict> selectDictList();
}
