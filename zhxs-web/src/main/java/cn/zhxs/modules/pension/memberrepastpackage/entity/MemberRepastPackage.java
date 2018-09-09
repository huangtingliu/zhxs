package cn.zhxs.modules.pension.memberrepastpackage.entity;

import cn.zhxs.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 会员餐饮套餐信息
 * @Description: 会员餐饮套餐信息
 * @author huangtl
 * @date 2018-09-09 21:23:25
 * @version V1.0   
 *
 */
@TableName("member_repast_package")
@SuppressWarnings("serial")
public class MemberRepastPackage extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**收费标准*/
    @TableField(value = "price")
	private String price;
    /**套餐详情*/
    @TableField(value = "package_detail")
	private String packageDetail;
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
	 * 获取  price
	 *@return: String  收费标准
	 */
	public String getPrice(){
		return this.price;
	}

	/**
	 * 设置  price
	 *@param: price  收费标准
	 */
	public void setPrice(String price){
		this.price = price;
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
	
}
