package com.cstech.cwanime.core;

import java.security.SecureRandom;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * 获取salt值
 * @author Satsuki.Cyan
 * @date 2019-03-27 17:57:23
 */
public class SaltUtils {

	public static String getSalt() {
		Random RANDOM = new SecureRandom();
		byte[] bytes = new byte[ 16 ];
		RANDOM.nextBytes( bytes );
		String salt = new BASE64Encoder().encode( bytes );

		return salt;
	}
}
