package cn.zhxs.modules.pension.nursing.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import cn.zhxs.modules.sys.entity.User;
import java.util.Date;

/**   
 * @Title: MemberNursing
 * @Description: 护理
 * @author huangtl
 * @date 2018-08-26 22:39:52
 * @version V1.0   
 *
 */
@TableName("member_nursing")
@SuppressWarnings("serial")
public class MemberNursing extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**护理级别*/
    @TableField(value = "nursing_level")
	private String nursingLevel;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**护理费用*/
    @TableField(value = "nursing_fee")
	private String nursingFee;
    /**级别说明*/
    @TableField(value = "level_desc")
	private String levelDesc;
    /**私人定制费用*/
    @TableField(value = "Custom_fee")
	private String CustomFee;
    /**护理总费用*/
    @TableField(value = "total_fee")
	private String totalFee;
    @TableField(value = "member_id")
	private String memberId;
    @TableField(value = "custom_service",exist = false)
	private String customService;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取  nursingLevel
	 *@return: String  护理级别
	 */
	public String getNursingLevel(){
		return this.nursingLevel;
	}

	/**
	 * 设置  nursingLevel
	 *@param: nursingLevel  护理级别
	 */
	public void setNursingLevel(String nursingLevel){
		this.nursingLevel = nursingLevel;
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
	 * 获取  nursingFee
	 *@return: String  护理费用
	 */
	public String getNursingFee(){
		return this.nursingFee;
	}

	/**
	 * 设置  nursingFee
	 *@param: nursingFee  护理费用
	 */
	public void setNursingFee(String nursingFee){
		this.nursingFee = nursingFee;
	}
	/**
	 * 获取  levelDesc
	 *@return: String  级别说明
	 */
	public String getLevelDesc(){
		return this.levelDesc;
	}

	/**
	 * 设置  levelDesc
	 *@param: levelDesc  级别说明
	 */
	public void setLevelDesc(String levelDesc){
		this.levelDesc = levelDesc;
	}
	/**
	 * 获取  CustomFee
	 *@return: String  私人定制费用
	 */
	public String getCustomFee(){
		return this.CustomFee;
	}

	/**
	 * 设置  CustomFee
	 *@param: CustomFee  私人定制费用
	 */
	public void setCustomFee(String CustomFee){
		this.CustomFee = CustomFee;
	}
	/**
	 * 获取  totalFee
	 *@return: String  护理总费用
	 */
	public String getTotalFee(){
		return this.totalFee;
	}

	/**
	 * 设置  totalFee
	 *@param: totalFee  护理总费用
	 */
	public void setTotalFee(String totalFee){
		this.totalFee = totalFee;
	}

	public String getCustomService() {
		return customService;
	}

	public void setCustomService(String customService) {
		this.customService = customService;
	}
}
