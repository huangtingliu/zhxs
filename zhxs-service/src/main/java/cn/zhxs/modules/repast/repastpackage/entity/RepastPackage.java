package cn.zhxs.modules.repast.repastpackage.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 饮食套餐
 * @Description: 饮食套餐
 * @author huangtl
 * @date 2018-09-02 14:59:17
 * @version V1.0   
 *
 */
@TableName("repast_package")
@SuppressWarnings("serial")
public class RepastPackage extends AbstractEntity<String> {

    /**主键id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**套餐名称*/
    @TableField(value = "package_name")
	private String packageName;
    /**价格区间*/
    @TableField(value = "price_range")
	private String price_range;
    /**收费标准*/
    @TableField(value = "price")
	private Double price;
    /**收费时间*/
    @TableField(value = "price_time")
	private String priceTime;
    /**套餐描述*/
    @TableField(value = "package_desc")
	private String packageDesc;
    /**菜品类目搭配*/
    @TableField(value = "food_type_desc")
	private String foodTypeDesc;
    @TableField(value = "create_time")
	private String createTime;

	/**
	 * 获取  id
	 *@return: String  主键id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  主键id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  packageName
	 *@return: String  套餐名称
	 */
	public String getPackageName(){
		return this.packageName;
	}

	/**
	 * 设置  packageName
	 *@param: packageName  套餐名称
	 */
	public void setPackageName(String packageName){
		this.packageName = packageName;
	}
	/**
	 * 获取  price_range
	 *@return: String  价格区间
	 */
	public String getPrice_range(){
		return this.price_range;
	}

	/**
	 * 设置  price_range
	 *@param: price_range  价格区间
	 */
	public void setPrice_range(String price_range){
		this.price_range = price_range;
	}
	/**
	 * 获取  price
	 *@return: Double  收费标准
	 */
	public Double getPrice(){
		return this.price;
	}

	/**
	 * 设置  price
	 *@param: price  收费标准
	 */
	public void setPrice(Double price){
		this.price = price;
	}
	/**
	 * 获取  priceTime
	 *@return: String  收费时间
	 */
	public String getPriceTime(){
		return this.priceTime;
	}

	/**
	 * 设置  priceTime
	 *@param: priceTime  收费时间
	 */
	public void setPriceTime(String priceTime){
		this.priceTime = priceTime;
	}
	/**
	 * 获取  packageDesc
	 *@return: String  套餐描述
	 */
	public String getPackageDesc(){
		return this.packageDesc;
	}

	/**
	 * 设置  packageDesc
	 *@param: packageDesc  套餐描述
	 */
	public void setPackageDesc(String packageDesc){
		this.packageDesc = packageDesc;
	}
	/**
	 * 获取  foodTypeDesc
	 *@return: String  菜品类目搭配
	 */
	public String getFoodTypeDesc(){
		return this.foodTypeDesc;
	}

	/**
	 * 设置  foodTypeDesc
	 *@param: foodTypeDesc  菜品类目搭配
	 */
	public void setFoodTypeDesc(String foodTypeDesc){
		this.foodTypeDesc = foodTypeDesc;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}