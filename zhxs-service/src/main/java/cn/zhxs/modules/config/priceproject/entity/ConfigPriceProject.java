package cn.zhxs.modules.config.priceproject.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 费用项目
 * @Description: 费用项目
 * @author huangtl
 * @date 2018-09-16 17:28:17
 * @version V1.0   
 *
 */
@TableName("config_price_project")
@SuppressWarnings("serial")
public class ConfigPriceProject extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**创建者*/
    @TableField(value = "create_by",el="createBy.id",fill = FieldFill.INSERT)
	private User createBy;
    /**创建时间*/
    @TableField(value = "create_date",fill = FieldFill.INSERT)
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
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**费用项目*/
    @TableField(value = "project_name")
	private String projectName;
    /**费用子项*/
    @TableField(value = "price_items")
	private String priceItems;
    /**费用类别*/
    @TableField(value = "price_type")
	private String priceType;
    /**收费标准*/
    @TableField(value = "price")
	private Double price;
	
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
	 *@return: String  创建时间
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
	 *@return: String  更新时间
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
	 * 获取  remarks
	 *@return: String  备注信息
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param: remarks  备注信息
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/**
	 * 获取  projectName
	 *@return: String  费用项目
	 */
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 * 设置  projectName
	 *@param: projectName  费用项目
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 * 获取  priceItems
	 *@return: String  费用子项
	 */
	public String getPriceItems(){
		return this.priceItems;
	}

	/**
	 * 设置  priceItems
	 *@param: priceItems  费用子项
	 */
	public void setPriceItems(String priceItems){
		this.priceItems = priceItems;
	}
	/**
	 * 获取  priceType
	 *@return: String  费用类别
	 */
	public String getPriceType(){
		return this.priceType;
	}

	/**
	 * 设置  priceType
	 *@param: priceType  费用类别
	 */
	public void setPriceType(String priceType){
		this.priceType = priceType;
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
	
}
