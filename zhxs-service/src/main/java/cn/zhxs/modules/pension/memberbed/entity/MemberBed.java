package cn.zhxs.modules.pension.memberbed.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;

/**   
 * @Title: 会员床位信息
 * @Description: 会员床位信息
 * @author huangtl
 * @date 2018-09-09 21:45:18
 * @version V1.0   
 *
 */
@TableName("member_bed")
@SuppressWarnings("serial")
public class MemberBed extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**房间类型*/
    @TableField(value = "room_type")
	private String roomType;
    /**是否包房*/
    @TableField(value = "is_private")
	private String isPrivate;
    /**床位类型*/
    @TableField(value = "bed_type")
	private String bedType;
    /**床位编号*/
    @TableField(value = "bed_no")
	private String bedNo;
    /**床位费用*/
    @TableField(value = "bed_price")
	private String bedPrice;
    /**会员id*/
    @TableField(value = "member_id")
	private String memberId;
	
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
	 * 获取  roomType
	 *@return: String  房间类型
	 */
	public String getRoomType(){
		return this.roomType;
	}

	/**
	 * 设置  roomType
	 *@param: roomType  房间类型
	 */
	public void setRoomType(String roomType){
		this.roomType = roomType;
	}
	/**
	 * 获取  isPrivate
	 *@return: String  是否包房
	 */
	public String getIsPrivate(){
		return this.isPrivate;
	}

	/**
	 * 设置  isPrivate
	 *@param: isPrivate  是否包房
	 */
	public void setIsPrivate(String isPrivate){
		this.isPrivate = isPrivate;
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
	 * 获取  bedPrice
	 *@return: String  床位费用
	 */
	public String getBedPrice(){
		return this.bedPrice;
	}

	/**
	 * 设置  bedPrice
	 *@param: bedPrice  床位费用
	 */
	public void setBedPrice(String bedPrice){
		this.bedPrice = bedPrice;
	}
	/**
	 * 获取  memberId
	 *@return: String  会员id
	 */
	public String getMemberId(){
		return this.memberId;
	}

	/**
	 * 设置  memberId
	 *@param: memberId  会员id
	 */
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
}
