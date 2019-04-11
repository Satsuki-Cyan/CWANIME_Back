package com.cstech.cwanime.service;

/**
 * redis缓存服务
 * @author Satsuki.Cyan
 * @date 2019-03-29 12:48:23
 */
public interface RedisService {

	/**
	 * 存入redis缓存（默认过期时间为一周）
	 * @param key
	 * @param value
	 */
	public void set( String key, String value );

	/**
	 * 存入redis缓存，自定义过期时间
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	public void set( String key, String value, Long expireTime );

	/**
	 * 查询是否key存在
	 * @param key
	 * @return boolean
	 */
	public Boolean isExists( final String key );

	/**
	 * 根据key查询并返回value
	 * @param key
	 * @return String
	 */
	public String get( String key );

	/**
	 * 根据key删除缓存信息
	 * @param key
	 */
	public void delete( String key );
}
