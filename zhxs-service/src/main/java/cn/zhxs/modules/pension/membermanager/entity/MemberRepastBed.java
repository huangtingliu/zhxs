package cn.zhxs.modules.pension.membermanager.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import cn.zhxs.modules.sys.entity.User;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**   
 * @Title: 会员餐饮套餐信息
 * @Description: 会员餐饮套餐信息
 * @author huangtl
 * @date 2018-09-09 21:23:25
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class MemberRepastBed{

    /**套餐id*/
    @TableField(value = "package_id")
	private String packageId;
    /**收费标准*/
    @TableField(value = "package_price")
	private String packagePrice;
    /**套餐详情*/
    @TableField(value = "package_detail")
	private String packageDetail;
    /**会员id*/
    @TableField(value = "member_id")
	private String memberId;
	/**会员床位id*/
	@TableId(value = "member_bed_id")
	private String bedId;
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

	/**
	 * 获取  packageId
	 *@return: String  套餐id
	 */
	public String getPackageId(){
		return this.packageId;
	}

	/**
	 * 设置  packageId
	 *@param: packageId  套餐id
	 */
	public void setPackageId(String packageId){
		this.packageId = packageId;
	}

	public String getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}

	/**
	 * 获取  packageDetail
	 *@return: String  套餐详情
	 */
	public String getPackageDetail(){
		return this.packageDetail;
	}

	/**
	 * 设置  packageDetail
	 *@param: packageDetail  套餐详情
	 */
	public void setPackageDetail(String packageDetail){
		this.packageDetail = packageDetail;
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

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getBedPrice() {
		return bedPrice;
	}

	public void setBedPrice(String bedPrice) {
		this.bedPrice = bedPrice;
	}
}
