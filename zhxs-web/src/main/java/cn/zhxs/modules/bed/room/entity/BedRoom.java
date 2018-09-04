package cn.zhxs.modules.bed.room.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 房间
 * @Description: 房间
 * @author huangtl
 * @date 2018-09-02 18:43:15
 * @version V1.0   
 *
 */
@TableName("bed_room")
@SuppressWarnings("serial")
public class BedRoom extends AbstractEntity<String> {

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
    /**房间编号*/
    @TableField(value = "room_no")
	private String roomNo;
    /**房间类别*/
    @TableField(value = "room_type")
	private String roomType;
    /**床位数*/
    @TableField(value = "bed_number")
	private String bedNumber;
    /**护理类别*/
    @TableField(value = "nursing_type")
	private String nursingType;
    /**楼层id*/
    @TableField(value = "floor_id")
	private String floorId;
	
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
	 * 获取  roomNo
	 *@return: String  房间编号
	 */
	public String getRoomNo(){
		return this.roomNo;
	}

	/**
	 * 设置  roomNo
	 *@param: roomNo  房间编号
	 */
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	/**
	 * 获取  roomType
	 *@return: String  房间类别
	 */
	public String getRoomType(){
		return this.roomType;
	}

	/**
	 * 设置  roomType
	 *@param: roomType  房间类别
	 */
	public void setRoomType(String roomType){
		this.roomType = roomType;
	}
	/**
	 * 获取  bedNumber
	 *@return: String  床位数
	 */
	public String getBedNumber(){
		return this.bedNumber;
	}

	/**
	 * 设置  bedNumber
	 *@param: bedNumber  床位数
	 */
	public void setBedNumber(String bedNumber){
		this.bedNumber = bedNumber;
	}
	/**
	 * 获取  nursingType
	 *@return: String  护理类别
	 */
	public String getNursingType(){
		return this.nursingType;
	}

	/**
	 * 设置  nursingType
	 *@param: nursingType  护理类别
	 */
	public void setNursingType(String nursingType){
		this.nursingType = nursingType;
	}
	/**
	 * 获取  floorId
	 *@return: String  楼层id
	 */
	public String getFloorId(){
		return this.floorId;
	}

	/**
	 * 设置  floorId
	 *@param: floorId  楼层id
	 */
	public void setFloorId(String floorId){
		this.floorId = floorId;
	}
	
}
