package cn.zhxs.modules.repast.foodtype.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.core.query.wrapper.EntityWrapper;
import cn.zhxs.modules.repast.foodtype.mapper.RepastFoodTypeMapper;
import cn.zhxs.modules.repast.foodtype.entity.RepastFoodType;
import cn.zhxs.modules.repast.foodtype.service.IRepastFoodTypeService;
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
 * @Title: 菜品类目
 * @Description: 菜品类目
 * @author huangtl
 * @date 2018-09-01 11:43:50
 * @version V1.0   
 *
 */
@Transactional
@Service("repastFoodTypeService")
public class RepastFoodTypeServiceImpl  extends CommonServiceImpl<RepastFoodTypeMapper,RepastFoodType> implements  IRepastFoodTypeService {
	
	@Override
	public boolean insert(RepastFoodType repastFoodType) {
		// 保存主表
		super.insert(repastFoodType);
		return true;
	}
	
	@Override
	public boolean insertOrUpdate(RepastFoodType repastFoodType) {
		try {
			// 更新主表
			super.insertOrUpdate(repastFoodType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}
	
	
	
}
