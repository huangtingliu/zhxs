package cn.zhxs.modules.bed.house.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 楼宇
 * @Description: 楼宇
 * @author huangtl
 * @date 2018-09-02 18:37:28
 * @version V1.0   
 *
 */
@TableName("bed_house")
@SuppressWarnings("serial")
public class BedHouse extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**楼宇名称*/
    @TableField(value = "house_name")
	private String houseName;
    /**楼层数*/
    @TableField(value = "floor_number")
	private Integer floorNumber;
    /**创建时间*/
    @TableField(value = "create_time")
	private String createTime;
    /**创建人*/
    @TableField(value = "create_by",el="createBy.id",fill = FieldFill.INSERT)
	private User createBy;
    /**删除表示*/
    @TableField(value = "del_flag")
	private String delFlag;
	
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
	 * 获取  houseName
	 *@return: String  楼宇名称
	 */
	public String getHouseName(){
		return this.houseName;
	}

	/**
	 * 设置  houseName
	 *@param: houseName  楼宇名称
	 */
	public void setHouseName(String houseName){
		this.houseName = houseName;
	}
	/**
	 * 获取  floorNumber
	 *@return: Integer  楼层数
	 */
	public Integer getFloorNumber(){
		return this.floorNumber;
	}

	/**
	 * 设置  floorNumber
	 *@param: floorNumber  楼层数
	 */
	public void setFloorNumber(Integer floorNumber){
		this.floorNumber = floorNumber;
	}
	/**
	 * 获取  createTime
	 *@return: String  创建时间
	 */
	public String getCreateTime(){
		return this.createTime;
	}

	/**
	 * 设置  createTime
	 *@param: createTime  创建时间
	 */
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	/**
	 * 获取  createBy
	 *@return: User  创建人
	 */
	public User getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param: createBy  创建人
	 */
	public void setCreateBy(User createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  delFlag
	 *@return: String  删除表示
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  删除表示
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	
}