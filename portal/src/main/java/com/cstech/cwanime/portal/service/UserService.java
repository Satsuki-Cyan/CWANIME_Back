package com.cstech.cwanime.portal.service;

import java.util.List;

import com.cstech.cwanime.bean.PageResult;
import com.cstech.cwanime.portal.service.bo.UserBO;
import com.github.pagehelper.PageInfo;

/**
 * 用户 service
 * @author Satsuki
 * @date 2019-03-12
 */
public interface UserService {

	/**
	 * 新增 - 用户信息
	 * @param userBO
	 * @return UserBO
	 */
	UserBO insertUser( UserBO userBO );

	/**
	 * 修改 - 用户信息
	 * @param userBO
	 * @return Integer
	 */
	Integer updateUser( UserBO userBO );

	/**
	 * 查询Obj - 用户信息
	 * @param userBO
	 * @return UserBO
	 */
	UserBO getUser( UserBO userBO );

	/**
	 * 查询集合 - 用户信息
	 * @param userBO
	 * @return List<UserBO>
	 */
	List<UserBO> listUsers( UserBO userBO );

	/**
	 * 分页查询 - 用户信息
	 * @param userBO
	 * @param pageInfo
	 * @return PageResult<UserBO>
	 */
	PageResult<UserBO> queryUserByPage( UserBO userBO, PageInfo pageInfo );

}
