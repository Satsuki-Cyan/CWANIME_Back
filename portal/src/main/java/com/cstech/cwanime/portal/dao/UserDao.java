package com.cstech.cwanime.portal.dao;

import java.util.List;

import com.cstech.cwanime.bean.PageResult;
import com.cstech.cwanime.portal.dao.domain.User;
import com.github.pagehelper.Page;

/**
 * 用户 dao
 * @author Satsuki
 * @date 2019-03-12
 */
public interface UserDao {

	/**
	 * 新增 - 用户信息
	 * @param User
	 * @return Integer
	 */
	Integer insertUser( User User );

	/**
	 * 修改 - 用户信息
	 * @param User
	 * @return Integer
	 */
	Integer updateUser( User User );

	/**
	 * 查询Obj - 用户信息
	 * @param User
	 * @return User
	 */
	User getUser( User User );

	/**
	 * 查询集合 - 用户信息
	 * @param User
	 * @return List<User>
	 */
	List<User> listUsers( User User );

	/**
	 * 分页查询 - 用户信息
	 * @param User
	 * @return User
	 */
	Page<User> queryUserByPage(User User );

}
