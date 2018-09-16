package cn.zhxs.modules.config.priceproject.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.config.priceproject.mapper.ConfigPriceProjectMapper;
import cn.zhxs.modules.config.priceproject.entity.ConfigPriceProject;
import cn.zhxs.modules.config.priceproject.service.IConfigPriceProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 费用项目
 * @Description: 费用项目
 * @author huangtl
 * @date 2018-09-16 17:28:17
 * @version V1.0   
 *
 */
@Transactional
@Service("configPriceProjectService")
public class ConfigPriceProjectServiceImpl  extends CommonServiceImpl<ConfigPriceProjectMapper,ConfigPriceProject> implements  IConfigPriceProjectService {

}
