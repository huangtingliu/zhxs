package cn.zhxs.modules.repast.foodtype.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 菜品类目
 * @Description: 菜品类目
 * @author huangtl
 * @date 2018-09-01 11:43:50
 * @version V1.0   
 *
 */
@TableName("repast_food_type")
@SuppressWarnings("serial")
public class RepastFoodType extends AbstractEntity<String> {

    /**类目名称*/
    @TableField(value = "type_name")
	private String typeName;
    /**价格区间*/
    @TableField(value = "price_range")
	private String priceRange;
    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**价格描述*/
    @TableField(value = "type_desc")
	private String typeDesc;
    /**是否删除*/
    @TableField(value = "delFlag")
	private String delFlag;
	
	/**
	 * 获取  typeName
	 *@return: String  类目名称
	 */
	public String getTypeName(){
		return this.typeName;
	}

	/**
	 * 设置  typeName
	 *@param: typeName  类目名称
	 */
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	/**
	 * 获取  priceRange
	 *@return: String  价格区间
	 */
	public String getPriceRange(){
		return this.priceRange;
	}

	/**
	 * 设置  priceRange
	 *@param: priceRange  价格区间
	 */
	public void setPriceRange(String priceRange){
		this.priceRange = priceRange;
	}
	/**
	 * 获取  id
	 *@return: String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  typeDesc
	 *@return: String  价格描述
	 */
	public String getTypeDesc(){
		return this.typeDesc;
	}

	/**
	 * 设置  typeDesc
	 *@param: typeDesc  价格描述
	 */
	public void setTypeDesc(String typeDesc){
		this.typeDesc = typeDesc;
	}
	/**
	 * 获取  delFlag
	 *@return: String  是否删除
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  是否删除
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	
}