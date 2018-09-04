package cn.zhxs.modules.bed.floor.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 楼层
 * @Description: 楼层
 * @author huangtl
 * @date 2018-09-02 18:41:57
 * @version V1.0   
 *
 */
@TableName("bed_floor")
@SuppressWarnings("serial")
public class BedFloor extends AbstractEntity<String> {

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
    @TableField(value = "update_date")
	private String updateDate;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**楼层*/
    @TableField(value = "floor")
	private String floor;
    /**楼层编号*/
    @TableField(value = "floor_no")
	private Integer floorNo;
    /**房间数*/
    @TableField(value = "room_number")
	private Integer roomNumber;
    /**区域类别*/
    @TableField(value = "area_type")
	private String areaType;
    /**楼宇Id*/
    @TableField(value = "house_id")
	private String houseId;
    @TableField(value = "house_name",exist = false)
	private String houseName;

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
	 * 获取  floor
	 *@return: String  楼层
	 */
	public String getFloor(){
		return this.floor;
	}

	/**
	 * 设置  floor
	 *@param: floor  楼层
	 */
	public void setFloor(String floor){
		this.floor = floor;
	}
	/**
	 * 获取  floorNo
	 *@return: Integer  楼层编号
	 */
	public Integer getFloorNo(){
		return this.floorNo;
	}

	/**
	 * 设置  floorNo
	 *@param: floorNo  楼层编号
	 */
	public void setFloorNo(Integer floorNo){
		this.floorNo = floorNo;
	}
	/**
	 * 获取  roomNumber
	 *@return: Integer  房间数
	 */
	public Integer getRoomNumber(){
		return this.roomNumber;
	}

	/**
	 * 设置  roomNumber
	 *@param: roomNumber  房间数
	 */
	public void setRoomNumber(Integer roomNumber){
		this.roomNumber = roomNumber;
	}
	/**
	 * 获取  areaType
	 *@return: String  区域类别
	 */
	public String getAreaType(){
		return this.areaType;
	}

	/**
	 * 设置  areaType
	 *@param: areaType  区域类别
	 */
	public void setAreaType(String areaType){
		this.areaType = areaType;
	}
	/**
	 * 获取  houseId
	 *@return: String  楼宇Id
	 */
	public String getHouseId(){
		return this.houseId;
	}

	/**
	 * 设置  houseId
	 *@param: houseId  楼宇Id
	 */
	public void setHouseId(String houseId){
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
}
