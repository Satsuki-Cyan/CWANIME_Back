package com.cstech.cwanime.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.cstech.cwanime.constants.BaseConstant;
import com.cstech.cwanime.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * redis缓存服务
 * @author Satsuki.Cyan
 * @date 2019-03-29 12:48:23
 */
@Service( "redisService" )
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 存入redis缓存（默认过期时间为一周）
	 * @param key
	 * @param value
	 */
	@Override
	public void set( String key, String value ) {
		redisTemplate.opsForValue().set( key, value, BaseConstant.WEEK_SECONDS, TimeUnit.SECONDS );
	}

	/**
	 * 存入redis缓存，自定义过期时间
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	@Override
	public void set( String key, String value, Long expireTime ) {
		redisTemplate.opsForValue().set( key, value, expireTime, TimeUnit.SECONDS );
	}

	/**
	 * 查询是否key存在
	 * @param key
	 * @return boolean
	 */
	@Override
	public Boolean isExists( final String key ) {
		return redisTemplate.hasKey( key );
	}

	/**
	 * 根据key查询并返回value
	 * @param key
	 * @return String
	 */
	@Override
	public String get( String key ) {
		return redisTemplate.opsForValue().get( key );
	}

	/**
	 * 根据key删除缓存信息
	 * @param key
	 */
	@Override
	public void delete( String key ) {
		redisTemplate.delete( key );
	}

}
