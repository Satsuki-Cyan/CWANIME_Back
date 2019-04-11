package com.cstech.cwanime.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 对 字符串/文件 进行散列
 * @author Satsuki.Cyan
 * @date 2019-03-27 17:56:23
 */
public class HashUtils {

	private static Logger LOGGER = LoggerFactory.getLogger( HashUtils.class );

	public static String getMD5( String str ) {
		return hash( str, "MD5" );
	}

	public static String getMD5( File file ) {
		return hash( file, "MD5" );
	}

	public static String getSHA1( String str ) {
		return hash( str, "SHA1" );
	}

	public static String getSHA1( File file ) {
		return hash( file, "SHA1" );
	}

	/**
	 * 计算字符串的hash值
	 * @param string    明文
	 * @param algorithm 算法名
	 * @return String   字符串的hash值
	 */
	private static String hash( String string, String algorithm ) {
		String result = "";
		if( !StringUtils.isEmpty( string ) ) {
			MessageDigest hash = null;
			try {
				hash = MessageDigest.getInstance( algorithm );
				byte[] bytes = hash.digest( string.getBytes( "UTF-8" ) );
				for( byte b : bytes ) {
					String temp = Integer.toHexString( b & 0xff );
					if( temp.length() == 1 ) {
						temp = "0" + temp;
					}
					result += temp;
				}
			} catch( NoSuchAlgorithmException e ) {
				LOGGER.error( " HashUtils.hash(String) have sth error, type of 'NoSuchAlgorithmException', info: {}", e );
			} catch( UnsupportedEncodingException e ) {
				LOGGER.error( " HashUtils.hash(String) have sth error, type of 'NoSuchAlgorithmException', info: {}", e );
			}
		}
		return result;
	}

	/**
	 * 计算文件的hash值
	 * @param file      文件File
	 * @param algorithm 算法名
	 * @return          文件的hash值
	 */
	private static String hash( File file, String algorithm ) {
		String result = "";
		if( file != null && file.isFile() && file.exists() ) {
			FileInputStream in = null;
			byte[] buffer = new byte[ 1024 ];
			int len;
			try {
				MessageDigest hash = MessageDigest.getInstance( algorithm );
				in = new FileInputStream( file );
				while( ( len = in.read( buffer ) ) != -1 ) {
					hash.update( buffer, 0, len );
				}
				byte[] bytes = hash.digest();

				for( byte b : bytes ) {
					String temp = Integer.toHexString( b & 0xff );
					if( temp.length() == 1 ) {
						temp = "0" + temp;
					}
					result += temp;
				}
			} catch( Exception e ) {
				LOGGER.error( " HashUtils.hash(file) have sth error, type of 'Exception', info: {}", e );
			} finally {
				if( null != in ) {
					try {
						in.close();
					} catch( IOException e ) {
						LOGGER.error( " HashUtils.hash(file) have sth error, type of 'IOException', info: {}", e );
					}
				}
			}
		}
		return result;
	}

}
