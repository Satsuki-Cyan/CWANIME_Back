package com.cstech.cwanime.portal.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cstech.cwanime.core.HashUtils;
import com.cstech.cwanime.core.SaltUtils;
import com.cstech.cwanime.core.TokenUtils;
import com.cstech.cwanime.service.RedisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstech.cwanime.bean.PageResult;
import com.cstech.cwanime.core.BeanObjectCopyUtils;
import com.cstech.cwanime.portal.dao.UserDao;
import com.cstech.cwanime.portal.dao.domain.User;
import com.cstech.cwanime.portal.service.UserService;
import com.cstech.cwanime.portal.service.bo.UserBO;

/**
 * 用户 serviceImpl
 * @author Satsuki
 * @date 2019-03-12
 */
@Service( "userService" )
public class UserServiceImpl implements UserService {

	private static Logger LOGGER = LoggerFactory.getLogger( UserServiceImpl.class );

	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisService redisService;

	/**
	 * 新增 - 用户信息
	 * @param userBO
	 * @return Integer
	 */
	@Override
	public UserBO insertUser( UserBO userBO ) {
		// 1. 进行【一般逻辑】校验

		// 2. 获取salt
		String salt = SaltUtils.getSalt();
		userBO.setSalt( salt );

		// 3. concat用户输入的“密码”和2.获取的salt，并进行散列
		String md5Pwd = HashUtils.getMD5( salt.concat( userBO.getPassword() ) );
		userBO.setPassword( md5Pwd );

		// 4. 存入DB
		User user = BeanObjectCopyUtils.copyObject( new User(), userBO );
		userDao.insertUser( user );

		// 5. 生成token令牌，存入redis
		String token = TokenUtils.getToken();
		userBO.setToken( token );
		redisService.set( token, JSON.toJSONString( userBO ) );
		LOGGER.info( "Token : {} , JSON.toJSONString(resUserBO) : {}", token, JSON.toJSONString( userBO ) );

		// 6. 清除敏感字段
		userBO.setSalt( null );
		userBO.setPassword( null );

		return userBO;
	}

	/**
	 * 修改 - 用户信息
	 * @param userBO
	 * @return Integer
	 */
	@Override
	public Integer updateUser( UserBO userBO ) {
		return null;
	}

	/**
	 * 查询Obj - 用户信息
	 * @param userBO
	 * @return UserBO
	 */
	@Override
	public UserBO getUser( UserBO userBO ) {
		User user = BeanObjectCopyUtils.copyObject( new User(), userBO );
		LOGGER.info( user.toString() );
		user = userDao.getUser( user );
		return BeanObjectCopyUtils.copyObject( new UserBO(), user );
	}

	/**
	 * 查询集合 - 用户信息
	 * @param userBO
	 * @return List<UserBO>
	 */
	@Override
	public List<UserBO> listUsers( UserBO userBO ) {
		return null;
	}

	/**
	 * 分页查询 - 用户信息
	 * @param userBO
	 * @param pageInfo
	 * @return PageResult<UserBO>
	 */
	@Override
	public PageResult<UserBO> queryUserByPage( UserBO userBO, PageInfo pageInfo ) {
		User user = BeanObjectCopyUtils.copyObject( new User(), userBO );
		LOGGER.info( user.toString() );
		PageHelper.startPage( pageInfo.getPageNum(), pageInfo.getPageSize() );
		List<User> userList = userDao.listUsers( user );
		PageInfo<User> pageInfo1 = new PageInfo<>( userList );

		List<UserBO> userBOList = BeanObjectCopyUtils.copyListObjToListObj( UserBO.class, userList );

		return new PageResult<>( pageInfo1.getTotal(), userBOList );
	}

	// ------------------------------------------- private ----------------------------------------------------------

}
