package com.cstech.cwanime.portal.dao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户 - 登录记录 VO
 * @author Satsuki
 * @date 2019-03-12
 */
public class LoginRecord implements Serializable {

	/** id */
	private Integer id;

	/** 用户uid */
	private Integer userUid;

	/** 登录ip */
	private String ip;

	/** 网络供应商信息 */
	private String netSupplier;

	/** 登录日期 */
	private Date loginDate;

	/** 登录请求来源(1:SCANIME、2:XXXX) */
	private Integer source;

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
}
