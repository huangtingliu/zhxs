package cn.zhxs.modules.config.nursingproject.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.config.nursingproject.mapper.ConfigNursingProjectMapper;
import cn.zhxs.modules.config.nursingproject.entity.ConfigNursingProject;
import cn.zhxs.modules.config.nursingproject.service.IConfigNursingProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 护理项目配置
 * @Description: 护理项目配置
 * @author huangtl
 * @date 2018-09-16 18:02:40
 * @version V1.0   
 *
 */
@Transactional
@Service("configNursingProjectService")
public class ConfigNursingProjectServiceImpl  extends CommonServiceImpl<ConfigNursingProjectMapper,ConfigNursingProject> implements  IConfigNursingProjectService {

}
