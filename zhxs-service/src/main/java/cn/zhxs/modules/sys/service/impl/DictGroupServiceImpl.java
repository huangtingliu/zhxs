package cn.zhxs.modules.sys.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.sys.entity.DictGroup;
import cn.zhxs.modules.sys.mapper.DictGroupMapper;
import cn.zhxs.modules.sys.service.IDictGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
