package cn.zhxs.modules.pension.memberrelation.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**   
 * @Title: member_relation
 * @Description: member_relation
 * @author huangtl
 * @date 2018-08-26 15:34:29
 * @version V1.0   
 *
 */
@TableName("member_relation")
@SuppressWarnings("serial")
public class MemberRelation extends AbstractEntity<String> {

    /**relation_id*/
    @TableId(value = "relation_id", type = IdType.UUID)
	private String id;
    /**姓名*/
    @TableField(value = "person_name")
	private String personName;
    /**电话*/
    @TableField(value = "phone")
	private String phone;
    /**性别*/
    @TableField(value = "sex")
	private String sex;
    /**身份证*/
    @TableField(value = "id_card")
	private String idCard;
    /**与老人关系*/
    @TableField(value = "relation_type")
	private String relationType;
    /**是否监护人*/
    @TableField(value = "is_guardian")
	private String isGuardian;
    /**联系地址*/
    @TableField(value = "address")
	private String address;
    /**老人id*/
    @TableField(value = "member_id")
	private String memberId;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取  personName
	 *@return: String  姓名
	 */
	public String getPersonName(){
		return this.personName;
	}

	/**
	 * 设置  personName
	 *@param: personName  姓名
	 */
	public void setPersonName(String personName){
		this.personName = personName;
	}
	/**
	 * 获取  phone
	 *@return: String  电话
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 * 设置  phone
	 *@param: phone  电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * 获取  sex
	 *@return: String  性别
	 */
	public String getSex(){
		return this.sex;
	}

	/**
	 * 设置  sex
	 *@param: sex  性别
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 * 获取  idCard
	 *@return: String  身份证
	 */
	public String getIdCard(){
		return this.idCard;
	}

	/**
	 * 设置  idCard
	 *@param: idCard  身份证
	 */
	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
	/**
	 * 获取  relationType
	 *@return: String  与老人关系
	 */
	public String getRelationType(){
		return this.relationType;
	}

	/**
	 * 设置  relationType
	 *@param: relationType  与老人关系
	 */
	public void setRelationType(String relationType){
		this.relationType = relationType;
	}
	/**
	 * 获取  isGuardian
	 *@return: String  是否监护人
	 */
	public String getIsGuardian(){
		return this.isGuardian;
	}

	/**
	 * 设置  isGuardian
	 *@param: isGuardian  是否监护人
	 */
	public void setIsGuardian(String isGuardian){
		this.isGuardian = isGuardian;
	}
	/**
	 * 获取  address
	 *@return: String  联系地址
	 */
	public String getAddress(){
		return this.address;
	}

	/**
	 * 设置  address
	 *@param: address  联系地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * 获取  memberId
	 *@return: String  老人id
	 */
	public String getMemberId(){
		return this.memberId;
	}

	/**
	 * 设置  memberId
	 *@param: memberId  老人id
	 */
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
}
