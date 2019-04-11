package com.cstech.cwanime.bean;

import java.io.Serializable;

/**
 * 异步请求返回对象
 * @author Satsuki
 * @param <T>
 */
public class AjaxMessageEntity<T> implements Serializable {

	private int code = 0;

	private String msg = "OK";

	T data;

	public AjaxMessageEntity() {}

	public int getCode() {
		return this.code;
	}

	public void setCode( int code ) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg( String msg ) {
		this.msg = msg;
	}

	public T getData() {
		return this.data;
	}

	public void setData( T data ) {
		this.data = data;
	}

	public void setMessager( int code, String msg ) {
		this.code = code;
		this.msg = msg;
	}
}
