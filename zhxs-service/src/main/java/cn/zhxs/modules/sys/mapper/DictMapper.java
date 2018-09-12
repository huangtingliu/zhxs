package cn.zhxs.modules.sys.mapper;

import cn.zhxs.modules.sys.entity.Dict;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
	List<Dict> selectDictList();
}