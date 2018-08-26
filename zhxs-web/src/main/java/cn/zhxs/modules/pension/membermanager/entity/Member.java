package cn.zhxs.modules.pension.membermanager.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: member
 * @Description: 老人会员基础信息
 * @author huangtl
 * @date 2018-08-17 17:50:10
 * @version V1.0   
 *
 */
@TableName("member")
@SuppressWarnings("serial")
public class Member extends AbstractEntity<String> {

    /**member_id*/
    @TableId(value = "member_id", type = IdType.UUID)
	private String id;
    /**档案编号*/
    @TableField(value = "member_no")
	private String memberNo;
    /**姓名*/
    @TableField(value = "member_name")
	private String memberName;
    /**电话*/
    @TableField(value = "phone")
	private String phone;
    /**身份证*/
    @TableField(value = "id_card")
	private String idCard;
    /**创建时间*/
    @TableField(value = "create_time")
	private String createTime;
    /**更新时间*/
    @TableField(value = "update_time")
	private String updateTime;
    /**生日*/
    @TableField(value = "birthday")
	private String birthday;
    /**性别 M：男 F：女*/
    @TableField(value = "sex")
	private String sex;
    /**人员类别 见字典*/
    @TableField(value = "person_type")
	private String personType;
    /**居住日期/入驻日期*/
    @TableField(value = "live_time")
	private String liveTime;
    /**合同签订日期*/
    @TableField(value = "contract_time")
	private String contractTime;
    /**经办人id*/
    @TableField(value = "create_user_id")
	private String createUserId;
    /**经办人姓名*/
    @TableField(value = "create_user_name")
	private String createUserName;
    /**婚姻状况 0：未婚 1：已婚*/
    @TableField(value = "marriage")
	private String marriage;
    /**家庭地址*/
    @TableField(value = "house_address")
	private String houseAddress;
    /**户籍地址*/
    @TableField(value = "census_register_address")
	private String censusRegisterAddress;
    /**是否本市户籍 见字典sf*/
    @TableField(value = "is_local")
	private String isLocal;
    /**是否w外地迁入 见字典sf*/
    @TableField(value = "is_immigration")
	private String isImmigration;
    /**原居住情况 见字典*/
    @TableField(value = "original_live_status")
	private String originalLiveStatus;
    /**家庭人口*/
    @TableField(value = "family_number")
	private Short familyNumber;
    /**宗教信仰*/
    @TableField(value = "faith")
	private String faith;
    /**爱好*/
    @TableField(value = "hobby")
	private String hobby;
    /**性格心理*/
    @TableField(value = "disposition")
	private String disposition;
    /**饮食特点*/
    @TableField(value = "diet")
	private String diet;
    /**文化程度 见字典*/
    @TableField(value = "culture")
	private String culture;
    /**劳动能力 见字典*/
    @TableField(value = "labor_capacity")
	private String laborCapacity;
    /**经济来源*/
    @TableField(value = "pocketbook")
	private String pocketbook;
    /**医疗保障*/
    @TableField(value = "Health_care")
	private String healthCare;
    /**医保卡号*/
    @TableField(value = "Health_care_card_number")
	private String healthCareCardNumber;
    /**头像照片地址*/
    @TableField(value = "profile_photo")
	private String profilePhoto;
    /**登记步骤 1.基本信息 2.家属信息 3.健康 4.护理任务 5.餐饮床位 6.入院缴费 7.附件*/
    @TableField(value = "step")
	private int step;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取  memberNo
	 *@return: String  档案编号
	 */
	public String getMemberNo(){
		return this.memberNo;
	}

	/**
	 * 设置  memberNo
	 *@param: memberNo  档案编号
	 */
	public void setMemberNo(String memberNo){
		this.memberNo = memberNo;
	}
	/**
	 * 获取  memberName
	 *@return: String  姓名
	 */
	public String getMemberName(){
		return this.memberName;
	}

	/**
	 * 设置  memberName
	 *@param: memberName  姓名
	 */
	public void setMemberName(String memberName){
		this.memberName = memberName;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取  birthday
	 *@return: String  生日
	 */
	public String getBirthday(){
		return this.birthday;
	}

	/**
	 * 设置  birthday
	 *@param: birthday  生日
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	/**
	 * 获取  sex
	 *@return: String  性别 M：男 F：女
	 */
	public String getSex(){
		return this.sex;
	}

	/**
	 * 设置  sex
	 *@param: sex  性别 M：男 F：女
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 * 获取  personType
	 *@return: String  人员类别 见字典
	 */
	public String getPersonType(){
		return this.personType;
	}

	/**
	 * 设置  personType
	 *@param: personType  人员类别 见字典
	 */
	public void setPersonType(String personType){
		this.personType = personType;
	}
	/**
	 * 获取  liveTime
	 *@return: String  居住日期/入驻日期
	 */
	public String getLiveTime(){
		return this.liveTime;
	}

	/**
	 * 设置  liveTime
	 *@param: liveTime  居住日期/入驻日期
	 */
	public void setLiveTime(String liveTime){
		this.liveTime = liveTime;
	}
	/**
	 * 获取  contractTime
	 *@return: String  合同签订日期
	 */
	public String getContractTime(){
		return this.contractTime;
	}

	/**
	 * 设置  contractTime
	 *@param: contractTime  合同签订日期
	 */
	public void setContractTime(String contractTime){
		this.contractTime = contractTime;
	}
	/**
	 * 获取  createUserId
	 *@return: String  经办人id
	 */
	public String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 * 设置  createUserId
	 *@param: createUserId  经办人id
	 */
	public void setCreateUserId(String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 * 获取  createUserName
	 *@return: String  经办人姓名
	 */
	public String getCreateUserName(){
		return this.createUserName;
	}

	/**
	 * 设置  createUserName
	 *@param: createUserName  经办人姓名
	 */
	public void setCreateUserName(String createUserName){
		this.createUserName = createUserName;
	}
	/**
	 * 获取  marriage
	 *@return: String  婚姻状况 0：未婚 1：已婚
	 */
	public String getMarriage(){
		return this.marriage;
	}

	/**
	 * 设置  marriage
	 *@param: marriage  婚姻状况 0：未婚 1：已婚
	 */
	public void setMarriage(String marriage){
		this.marriage = marriage;
	}
	/**
	 * 获取  houseAddress
	 *@return: String  家庭地址
	 */
	public String getHouseAddress(){
		return this.houseAddress;
	}

	/**
	 * 设置  houseAddress
	 *@param: houseAddress  家庭地址
	 */
	public void setHouseAddress(String houseAddress){
		this.houseAddress = houseAddress;
	}
	/**
	 * 获取  censusRegisterAddress
	 *@return: String  户籍地址
	 */
	public String getCensusRegisterAddress(){
		return this.censusRegisterAddress;
	}

	/**
	 * 设置  censusRegisterAddress
	 *@param: censusRegisterAddress  户籍地址
	 */
	public void setCensusRegisterAddress(String censusRegisterAddress){
		this.censusRegisterAddress = censusRegisterAddress;
	}
	/**
	 * 获取  isLocal
	 *@return: String  是否本市户籍 见字典sf
	 */
	public String getIsLocal(){
		return this.isLocal;
	}

	/**
	 * 设置  isLocal
	 *@param: isLocal  是否本市户籍 见字典sf
	 */
	public void setIsLocal(String isLocal){
		this.isLocal = isLocal;
	}
	/**
	 * 获取  isImmigration
	 *@return: String  是否w外地迁入 见字典sf
	 */
	public String getIsImmigration(){
		return this.isImmigration;
	}

	/**
	 * 设置  isImmigration
	 *@param: isImmigration  是否w外地迁入 见字典sf
	 */
	public void setIsImmigration(String isImmigration){
		this.isImmigration = isImmigration;
	}
	/**
	 * 获取  originalLiveStatus
	 *@return: String  原居住情况 见字典
	 */
	public String getOriginalLiveStatus(){
		return this.originalLiveStatus;
	}

	/**
	 * 设置  originalLiveStatus
	 *@param: originalLiveStatus  原居住情况 见字典
	 */
	public void setOriginalLiveStatus(String originalLiveStatus){
		this.originalLiveStatus = originalLiveStatus;
	}
	/**
	 * 获取  familyNumber
	 *@return: Short  家庭人口
	 */
	public Short getFamilyNumber(){
		return this.familyNumber;
	}

	/**
	 * 设置  familyNumber
	 *@param: familyNumber  家庭人口
	 */
	public void setFamilyNumber(Short familyNumber){
		this.familyNumber = familyNumber;
	}
	/**
	 * 获取  faith
	 *@return: String  宗教信仰
	 */
	public String getFaith(){
		return this.faith;
	}

	/**
	 * 设置  faith
	 *@param: faith  宗教信仰
	 */
	public void setFaith(String faith){
		this.faith = faith;
	}
	/**
	 * 获取  hobby
	 *@return: String  爱好
	 */
	public String getHobby(){
		return this.hobby;
	}

	/**
	 * 设置  hobby
	 *@param: hobby  爱好
	 */
	public void setHobby(String hobby){
		this.hobby = hobby;
	}
	/**
	 * 获取  disposition
	 *@return: String  性格心理
	 */
	public String getDisposition(){
		return this.disposition;
	}

	/**
	 * 设置  disposition
	 *@param: disposition  性格心理
	 */
	public void setDisposition(String disposition){
		this.disposition = disposition;
	}
	/**
	 * 获取  diet
	 *@return: String  饮食特点
	 */
	public String getDiet(){
		return this.diet;
	}

	/**
	 * 设置  diet
	 *@param: diet  饮食特点
	 */
	public void setDiet(String diet){
		this.diet = diet;
	}
	/**
	 * 获取  culture
	 *@return: String  文化程度 见字典
	 */
	public String getCulture(){
		return this.culture;
	}

	/**
	 * 设置  culture
	 *@param: culture  文化程度 见字典
	 */
	public void setCulture(String culture){
		this.culture = culture;
	}
	/**
	 * 获取  laborCapacity
	 *@return: String  劳动能力 见字典
	 */
	public String getLaborCapacity(){
		return this.laborCapacity;
	}

	/**
	 * 设置  laborCapacity
	 *@param: laborCapacity  劳动能力 见字典
	 */
	public void setLaborCapacity(String laborCapacity){
		this.laborCapacity = laborCapacity;
	}
	/**
	 * 获取  pocketbook
	 *@return: String  经济来源
	 */
	public String getPocketbook(){
		return this.pocketbook;
	}

	/**
	 * 设置  pocketbook
	 *@param: pocketbook  经济来源
	 */
	public void setPocketbook(String pocketbook){
		this.pocketbook = pocketbook;
	}
	/**
	 * 获取  healthCare
	 *@return: String  医疗保障
	 */
	public String getHealthCare(){
		return this.healthCare;
	}

	/**
	 * 设置  healthCare
	 *@param: healthCare  医疗保障
	 */
	public void setHealthCare(String healthCare){
		this.healthCare = healthCare;
	}
	/**
	 * 获取  healthCareCardNumber
	 *@return: String  医保卡号
	 */
	public String getHealthCareCardNumber(){
		return this.healthCareCardNumber;
	}

	/**
	 * 设置  healthCareCardNumber
	 *@param: healthCareCardNumber  医保卡号
	 */
	public void setHealthCareCardNumber(String healthCareCardNumber){
		this.healthCareCardNumber = healthCareCardNumber;
	}
	/**
	 * 获取  profilePhoto
	 *@return: String  头像照片地址
	 */
	public String getProfilePhoto(){
		return this.profilePhoto;
	}

	/**
	 * 设置  profilePhoto
	 *@param: profilePhoto  头像照片地址
	 */
	public void setProfilePhoto(String profilePhoto){
		this.profilePhoto = profilePhoto;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
