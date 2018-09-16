package cn.zhxs.modules.config.nursingproject.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 护理项目配置
 * @Description: 护理项目配置
 * @author huangtl
 * @date 2018-09-16 18:02:40
 * @version V1.0   
 *
 */
@TableName("config_nursing_project")
@SuppressWarnings("serial")
public class ConfigNursingProject extends AbstractEntity<String> {

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
    /**护理项目*/
    @TableField(value = "nursing_project")
	private String nursingProject;
    /**项目描述*/
    @TableField(value = "project_desc")
	private String projectDesc;
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
	 * 获取  nursingProject
	 *@return: String  护理项目
	 */
	public String getNursingProject(){
		return this.nursingProject;
	}

	/**
	 * 设置  nursingProject
	 *@param: nursingProject  护理项目
	 */
	public void setNursingProject(String nursingProject){
		this.nursingProject = nursingProject;
	}
	/**
	 * 获取  projectDesc
	 *@return: String  项目描述
	 */
	public String getProjectDesc(){
		return this.projectDesc;
	}

	/**
	 * 设置  projectDesc
	 *@param: projectDesc  项目描述
	 */
	public void setProjectDesc(String projectDesc){
		this.projectDesc = projectDesc;
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
