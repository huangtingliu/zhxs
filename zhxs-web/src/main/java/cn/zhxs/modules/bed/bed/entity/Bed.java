package cn.zhxs.modules.bed.bed.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 床位
 * @Description: 床位
 * @author huangtl
 * @date 2018-09-02 18:43:23
 * @version V1.0   
 *
 */
@TableName("bed")
@SuppressWarnings("serial")
public class Bed extends AbstractEntity<String> {

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
    /**床位编号*/
    @TableField(value = "bed_no")
	private String bedNo;
    /**床位类型*/
    @TableField(value = "bed_type")
	private String bedType;
    /**房间Id*/
    @TableField(value = "room_id")
	private String roomId;
	
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
	 * 获取  bedNo
	 *@return: String  床位编号
	 */
	public String getBedNo(){
		return this.bedNo;
	}

	/**
	 * 设置  bedNo
	 *@param: bedNo  床位编号
	 */
	public void setBedNo(String bedNo){
		this.bedNo = bedNo;
	}
	/**
	 * 获取  bedType
	 *@return: String  床位类型
	 */
	public String getBedType(){
		return this.bedType;
	}

	/**
	 * 设置  bedType
	 *@param: bedType  床位类型
	 */
	public void setBedType(String bedType){
		this.bedType = bedType;
	}
	/**
	 * 获取  roomId
	 *@return: String  房间Id
	 */
	public String getRoomId(){
		return this.roomId;
	}

	/**
	 * 设置  roomId
	 *@param: roomId  房间Id
	 */
	public void setRoomId(String roomId){
		this.roomId = roomId;
	}
	
}
