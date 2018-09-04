package cn.zhxs.modules.repast.repastpackage.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.core.query.wrapper.EntityWrapper;
import cn.zhxs.modules.repast.repastpackage.mapper.RepastPackageMapper;
import cn.zhxs.modules.repast.repastpackage.entity.RepastPackage;
import cn.zhxs.modules.repast.repastpackage.service.IRepastPackageService;
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
 * @Title: 饮食套餐
 * @Description: 饮食套餐
 * @author huangtl
 * @date 2018-09-02 14:59:17
 * @version V1.0   
 *
 */
@Transactional
@Service("repastPackageService")
public class RepastPackageServiceImpl  extends CommonServiceImpl<RepastPackageMapper,RepastPackage> implements  IRepastPackageService {
	
	@Override
	public boolean insert(RepastPackage repastPackage) {
		// 保存主表
		super.insert(repastPackage);
		return true;
	}
	
	@Override
	public boolean insertOrUpdate(RepastPackage repastPackage) {
		try {
			// 更新主表
			super.insertOrUpdate(repastPackage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}
	
	
	
}
