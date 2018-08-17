package cn.zhxs.modules.codegen.service;

import java.util.List;
import cn.zhxs.core.common.service.ICommonService;
import cn.zhxs.modules.codegen.entity.Column;

public interface IColumnService extends ICommonService<Column> {
	List<Column> selectListByTableId(String tableId);
}
