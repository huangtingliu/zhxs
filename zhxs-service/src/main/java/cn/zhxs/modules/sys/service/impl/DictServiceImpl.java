package cn.zhxs.modules.sys.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.sys.entity.Dict;
import cn.zhxs.modules.sys.mapper.DictMapper;
import cn.zhxs.modules.sys.service.IDictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public List<Dict> selectDictList() {
		return baseMapper.selectDictList();
	}

}
