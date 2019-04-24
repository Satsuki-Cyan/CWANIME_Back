package com.cstech.cwanime.portal.service.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户 - 信息 BO
 * @author Satsuki
 * @date 2019-03-12
 */
public class UserBO implements Serializable {

	/** id */
	private Long id;

	/** 用户uid */
	private Integer userUid;

	/** 手机号码 */
	private String telephone;

	/** 密码 */
	private String password;

	/** 盐值 */
	private String salt;

	/** 用户名 */
	private String accountNo;

	/** 邮箱 */
	private String eMail;

	/** 生日 */
	private Date birthday;

	/** 签名 */
	private String signature;

	/** 归属地（省） */
	private String province;

	/** 归属地（市） */
	private String city;

	/** 归属地（区） */
	private String borough;

	/** 邮编 */
	private String postalCode;

	/** 地址 */
	private String address;

	/** 真实姓名 */
	private String name;

	/** 身份证号 */
	private String idNo;

	/** 树叶（硬币） */
	private Integer leaf;

	/** 花瓣（b币） */
	private Integer petal;

	/** 用户经验值（等级直接算出） */
	private Integer userExp;

	/** vip经验值 */
	private Integer vipExp;

	/** 用户性质(1:普通用户、2:管理者) */
	private Integer role;

	/** 用户状态(1:待激活、2:已激活、3:冻结、4:已注销) */
	private Integer userStatus;

	/** 乐观锁 */
	private Integer dataVersion;

	/** 状态(1:保存 0:删除) */
	private Integer status;

	/** 创建人id */
	private String createBy;

	/** 创建人 */
	private String createByName;

	/** 创建时间 */
	private Date createTime;

	/** 修改人id */
	private String updateBy;

	/** 修改人 */
	private String updateByName;

	/** 修改时间 */
	private Date updateTime;

	/* 附加字段 */

	/** token */
	private String token;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone( String telephone ) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt( String salt ) {
		this.salt = salt;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo( String accountNo ) {
		this.accountNo = accountNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail( String eMail ) {
		this.eMail = eMail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday( Date birthday ) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature( String signature ) {
		this.signature = signature;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince( String province ) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough( String borough ) {
		this.borough = borough;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode( String postalCode ) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress( String address ) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo( String idNo ) {
		this.idNo = idNo;
	}

	public Integer getUserUid() {
		return userUid;
	}

	public void setUserUid( Integer userUid ) {
		this.userUid = userUid;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf( Integer leaf ) {
		this.leaf = leaf;
	}

	public Integer getPetal() {
		return petal;
	}

	public void setPetal( Integer petal ) {
		this.petal = petal;
	}

	public Integer getUserExp() {
		return userExp;
	}

	public void setUserExp( Integer userExp ) {
		this.userExp = userExp;
	}

	public Integer getVipExp() {
		return vipExp;
	}

	public void setVipExp( Integer vipExp ) {
		this.vipExp = vipExp;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole( Integer role ) {
		this.role = role;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus( Integer userStatus ) {
		this.userStatus = userStatus;
	}

	public Integer getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion( Integer dataVersion ) {
		this.dataVersion = dataVersion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus( Integer status ) {
		this.status = status;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy( String createBy ) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName( String createByName ) {
		this.createByName = createByName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy( String updateBy ) {
		this.updateBy = updateBy;
	}

	public String getUpdateByName() {
		return updateByName;
	}

	public void setUpdateByName( String updateByName ) {
		this.updateByName = updateByName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime( Date updateTime ) {
		this.updateTime = updateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken( String token ) {
		this.token = token;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer( "UserBO{" );
		sb.append( "id=" ).append( id );
		sb.append( ", telephone='" ).append( telephone ).append( '\'' );
		sb.append( ", password='" ).append( password ).append( '\'' );
		sb.append( ", salt='" ).append( salt ).append( '\'' );
		sb.append( ", accountNo='" ).append( accountNo ).append( '\'' );
		sb.append( ", eMail='" ).append( eMail ).append( '\'' );
		sb.append( ", birthday=" ).append( birthday );
		sb.append( ", signature='" ).append( signature ).append( '\'' );
		sb.append( ", province='" ).append( province ).append( '\'' );
		sb.append( ", city='" ).append( city ).append( '\'' );
		sb.append( ", borough='" ).append( borough ).append( '\'' );
		sb.append( ", postalCode='" ).append( postalCode ).append( '\'' );
		sb.append( ", address='" ).append( address ).append( '\'' );
		sb.append( ", name='" ).append( name ).append( '\'' );
		sb.append( ", idNo='" ).append( idNo ).append( '\'' );
		sb.append( ", userExp=" ).append( userExp );
		sb.append( ", vipExp=" ).append( vipExp );
		sb.append( ", role=" ).append( role );
		sb.append( ", userStatus=" ).append( userStatus );
		sb.append( ", dataVersion=" ).append( dataVersion );
		sb.append( ", status=" ).append( status );
		sb.append( ", createBy='" ).append( createBy ).append( '\'' );
		sb.append( ", createByName='" ).append( createByName ).append( '\'' );
		sb.append( ", createTime=" ).append( createTime );
		sb.append( ", updateBy='" ).append( updateBy ).append( '\'' );
		sb.append( ", updateByName='" ).append( updateByName ).append( '\'' );
		sb.append( ", updateTime=" ).append( updateTime );
		sb.append( ", token='" ).append( token ).append( '\'' );
		sb.append( '}' );
		return sb.toString();
	}
}
