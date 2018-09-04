package cn.zhxs.modules.repast.food.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;
import java.util.Date;

/**   
 * @Title: 菜品表
 * @Description: 菜品表
 * @author huangtl
 * @date 2018-09-02 15:50:46
 * @version V1.0   
 *
 */
@TableName("repast_food")
@SuppressWarnings("serial")
public class RepastFood extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**创建者*/
    @TableField(value = "create_by",el="createBy.id",fill = FieldFill.INSERT)
	private User createBy;
    /**创建时间*/
    @TableField(value = "create_date")
	private String createDate;
    /**更新者*/
    @TableField(value = "update_by",el="updateBy.id",fill = FieldFill.UPDATE)
	private User updateBy;
    /**更新时间*/
    @TableField(value = "update_date",fill = FieldFill.UPDATE)
	private String updateDate;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**菜品名称*/
    @TableField(value = "food_name")
	private String foodName;
    /**菜品类目*/
    @TableField(value = "type_id")
	private String typeId;
    @TableField(value = "type_name",exist = false)
	private String typeName;
    /**价格*/
    @TableField(value = "price")
	private Double price;
    /**菜品描述*/
    @TableField(value = "food_desc")
	private String foodDesc;
	
	/**
	 * 获取  id
	 *@return: String  字段主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  字段主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  createBy
	 *@return: User  创建者
	 */
	public User getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param: createBy  创建者
	 */
	public void setCreateBy(User createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return: Date  创建时间
	 */
	public String getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param: createDate  创建时间
	 */
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
	/**
	 * 获取  updateBy
	 *@return: User  更新者
	 */
	public User getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param: updateBy  更新者
	 */
	public void setUpdateBy(User updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return: Date  更新时间
	 */
	public String getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param: updateDate  更新时间
	 */
	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  delFlag
	 *@return: String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  foodName
	 *@return: String  菜品名称
	 */
	public String getFoodName(){
		return this.foodName;
	}

	/**
	 * 设置  foodName
	 *@param: foodName  菜品名称
	 */
	public void setFoodName(String foodName){
		this.foodName = foodName;
	}
	/**
	 * 获取  typeId
	 *@return: String  菜品类目
	 */
	public String getTypeId(){
		return this.typeId;
	}

	/**
	 * 设置  typeId
	 *@param: typeId  菜品类目
	 */
	public void setTypeId(String typeId){
		this.typeId = typeId;
	}
	/**
	 * 获取  price
	 *@return: Double  价格
	 */
	public Double getPrice(){
		return this.price;
	}

	/**
	 * 设置  price
	 *@param: price  价格
	 */
	public void setPrice(Double price){
		this.price = price;
	}
	/**
	 * 获取  foodDesc
	 *@return: String  菜品描述
	 */
	public String getFoodDesc(){
		return this.foodDesc;
	}

	/**
	 * 设置  foodDesc
	 *@param: foodDesc  菜品描述
	 */
	public void setFoodDesc(String foodDesc){
		this.foodDesc = foodDesc;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
