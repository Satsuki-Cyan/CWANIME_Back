package com.cstech.cwanime.portal.dao.impl;

import java.util.List;

import com.github.pagehelper.Page;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cstech.cwanime.bean.PageResult;
import com.cstech.cwanime.portal.dao.UserDao;
import com.cstech.cwanime.portal.dao.domain.User;

/**
 * 用户 daoImpl
 * @author Satsuki
 * @date 2019-03-13
 */
@Repository( "userDao" )
public class UserDaoImpl implements UserDao {

	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

	final String mapperId = "com.cstech.cwanime.portal.dao.domain.User.";

	@Override
	public Integer insertUser( User user ) {
		return this.sqlSessionTemplate.insert( mapperId.concat( "insertUser" ), user );
	}

	@Override
	public Integer updateUser( User user ) {
		return this.sqlSessionTemplate.update( mapperId.concat( "updateUser" ), user );
	}

	@Override
	public User getUser( User user ) {
		return this.sqlSessionTemplate.selectOne( mapperId.concat( "getUser" ), user );
	}

	@Override
	public List<User> listUsers( User user ) {
		return this.sqlSessionTemplate.selectList( mapperId.concat( "listUsers" ), user );
	}

	@Override
	public Page<User> queryUserByPage(User user ) {
//		PageRowBounds rowBounds = new PageRowBounds();
//		List<User> list = this.sqlSessionTemplate.selectList( mapperId.concat( "queryUserByPage" ), user, rowBounds );
//		return new PageResult<>( rowBounds.getTotal(), list );
		return null;
	}
}
