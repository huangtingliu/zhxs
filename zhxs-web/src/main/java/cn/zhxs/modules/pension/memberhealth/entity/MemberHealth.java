package cn.zhxs.modules.pension.memberhealth.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: member_health
 * @Description: member_health
 * @author huangtl
 * @date 2018-08-26 18:07:38
 * @version V1.0   
 *
 */
@TableName("member_health")
@SuppressWarnings("serial")
public class MemberHealth extends AbstractEntity<String> {

    /**health_id*/
    @TableId(value = "health_id", type = IdType.UUID)
	private String id;
    /**老人Id*/
    @TableField(value = "member_id")
	private String memberId;
    /**自理情况*/
    @TableField(value = "self_care")
	private String selfCare;
    /**视力*/
    @TableField(value = "vision")
	private String vision;
    /**主治医院*/
    @TableField(value = "main_hospital")
	private String mainHospital;
    /**主治医师*/
    @TableField(value = "main_physician")
	private String mainPhysician;
    /**医院电话*/
    @TableField(value = "hospital_phone")
	private String hospitalPhone;
    /**过敏药物*/
    @TableField(value = "drug_allergy")
	private String drugAllergy;
    /**疾病*/
    @TableField(value = "disease")
	private String disease;
    /**入驻前病史*/
    @TableField(value = "disease_history")
	private String diseaseHistory;
    /**听力*/
    @TableField(value = "hearing")
	private String hearing;
	
	/**
	 * 获取  id
	 *@return: String  health_id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  health_id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  memberId
	 *@return: String  老人Id
	 */
	public String getMemberId(){
		return this.memberId;
	}

	/**
	 * 设置  memberId
	 *@param: memberId  老人Id
	 */
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	/**
	 * 获取  selfCare
	 *@return: String  自理情况
	 */
	public String getSelfCare(){
		return this.selfCare;
	}

	/**
	 * 设置  selfCare
	 *@param: selfCare  自理情况
	 */
	public void setSelfCare(String selfCare){
		this.selfCare = selfCare;
	}
	/**
	 * 获取  vision
	 *@return: String  视力
	 */
	public String getVision(){
		return this.vision;
	}

	/**
	 * 设置  vision
	 *@param: vision  视力
	 */
	public void setVision(String vision){
		this.vision = vision;
	}
	/**
	 * 获取  mainHospital
	 *@return: String  主治医院
	 */
	public String getMainHospital(){
		return this.mainHospital;
	}

	/**
	 * 设置  mainHospital
	 *@param: mainHospital  主治医院
	 */
	public void setMainHospital(String mainHospital){
		this.mainHospital = mainHospital;
	}
	/**
	 * 获取  mainPhysician
	 *@return: String  主治医师
	 */
	public String getMainPhysician(){
		return this.mainPhysician;
	}

	/**
	 * 设置  mainPhysician
	 *@param: mainPhysician  主治医师
	 */
	public void setMainPhysician(String mainPhysician){
		this.mainPhysician = mainPhysician;
	}
	/**
	 * 获取  hospitalPhone
	 *@return: String  医院电话
	 */
	public String getHospitalPhone(){
		return this.hospitalPhone;
	}

	/**
	 * 设置  hospitalPhone
	 *@param: hospitalPhone  医院电话
	 */
	public void setHospitalPhone(String hospitalPhone){
		this.hospitalPhone = hospitalPhone;
	}
	/**
	 * 获取  drugAllergy
	 *@return: String  过敏药物
	 */
	public String getDrugAllergy(){
		return this.drugAllergy;
	}

	/**
	 * 设置  drugAllergy
	 *@param: drugAllergy  过敏药物
	 */
	public void setDrugAllergy(String drugAllergy){
		this.drugAllergy = drugAllergy;
	}
	/**
	 * 获取  disease
	 *@return: String  疾病
	 */
	public String getDisease(){
		return this.disease;
	}

	/**
	 * 设置  disease
	 *@param: disease  疾病
	 */
	public void setDisease(String disease){
		this.disease = disease;
	}
	/**
	 * 获取  diseaseHistory
	 *@return: String  入驻前病史
	 */
	public String getDiseaseHistory(){
		return this.diseaseHistory;
	}

	/**
	 * 设置  diseaseHistory
	 *@param: diseaseHistory  入驻前病史
	 */
	public void setDiseaseHistory(String diseaseHistory){
		this.diseaseHistory = diseaseHistory;
	}
	/**
	 * 获取  hearing
	 *@return: String  听力
	 */
	public String getHearing(){
		return this.hearing;
	}

	/**
	 * 设置  hearing
	 *@param: hearing  听力
	 */
	public void setHearing(String hearing){
		this.hearing = hearing;
	}
	
}
