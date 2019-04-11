package com.cstech.cwanime.core;

import java.util.UUID;

/**
 * 获取token
 * @author Satsuki.Cyan
 * @date 2019-03-28 17:38:23
 */
public class TokenUtils {

	/**
	 * 获得一个token
	 * @return String[]
	 */
	public static String getToken() {
		return UUID.randomUUID().toString().replaceAll( "-", "" );
	}

	/**
	 * 获得指定数目的token
	 * @param num
	 * @return String[]
	 */
	public static String[] getTokenArray( int num ) {
		if( num < 1 ) {
			return null;
		}
		String[] retArray = new String[ num ];
		for( int i = 0; i < num; i++ ) {
			retArray[ i ] = getToken();
		}
		return retArray;
	}
}
