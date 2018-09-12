package cn.zhxs.modules.sys.mapper;

import cn.zhxs.modules.sys.entity.UserOnline;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOnlineMapper extends BaseMapper<UserOnline> {
	
   List<UserOnline> selectUserOnlinePage(Page<UserOnline> page, @Param("ew") Wrapper<UserOnline> wrapper);
}