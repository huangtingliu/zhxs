package cn.zhxs.modules.repast.food.service.impl;

import cn.zhxs.core.common.service.impl.CommonServiceImpl;
import cn.zhxs.modules.repast.food.mapper.RepastFoodMapper;
import cn.zhxs.modules.repast.food.entity.RepastFood;
import cn.zhxs.modules.repast.food.service.IRepastFoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 菜品表
 * @Description: 菜品表
 * @author huangtl
 * @date 2018-09-02 15:50:46
 * @version V1.0   
 *
 */
@Transactional
@Service("repastFoodService")
public class RepastFoodServiceImpl  extends CommonServiceImpl<RepastFoodMapper,RepastFood> implements  IRepastFoodService {

}
