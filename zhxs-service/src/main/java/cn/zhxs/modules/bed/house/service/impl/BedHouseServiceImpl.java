package cn.zhxs.modules.bed.house.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.core.query.wrapper.EntityWrapper;
import cn.zhxs.modules.bed.house.mapper.BedHouseMapper;
import cn.zhxs.modules.bed.house.entity.BedHouse;
import cn.zhxs.modules.bed.house.service.IBedHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.zhxs.core.utils.ServletUtils;
import cn.zhxs.core.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

/**   
 * @Title: 楼宇
 * @Description: 楼宇
 * @author huangtl
 * @date 2018-09-02 18:37:28
 * @version V1.0   
 *
 */
@Transactional
@Service("bedHouseService")
public class BedHouseServiceImpl  extends CommonServiceImpl<BedHouseMapper,BedHouse> implements  IBedHouseService {
	
	@Override
	public boolean insert(BedHouse bedHouse) {
		// 保存主表
		super.insert(bedHouse);
		return true;
	}
	
	@Override
	public boolean insertOrUpdate(BedHouse bedHouse) {
		try {
			// 更新主表
			super.insertOrUpdate(bedHouse);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}
	
	
	
}
