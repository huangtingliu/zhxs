package cn.zhxs.modules.config.nursinglevel.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.config.nursinglevel.mapper.ConfigNursingLevelMapper;
import cn.zhxs.modules.config.nursinglevel.entity.ConfigNursingLevel;
import cn.zhxs.modules.config.nursinglevel.service.IConfigNursingLevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 护理等级配置
 * @Description: 护理等级配置
 * @author huangtl
 * @date 2018-09-16 17:50:12
 * @version V1.0   
 *
 */
@Transactional
@Service("configNursingLevelService")
public class ConfigNursingLevelServiceImpl  extends CommonServiceImpl<ConfigNursingLevelMapper,ConfigNursingLevel> implements  IConfigNursingLevelService {

}
