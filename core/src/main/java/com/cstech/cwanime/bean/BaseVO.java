package com.cstech.cwanime.bean;

import java.io.Serializable;

/**
 * @author Satsuki
 * @Description 前台传入的分页信息
 * @date 2019-03-26
 */
public class BaseVO implements Serializable {

	private Integer start;

	private Integer limit;

	public BaseVO() {}

	public BaseVO( Integer start, Integer limit ) {
		this.start = start;
		this.limit = limit;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart( Integer start ) {
		this.start = start;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit( Integer limit ) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "BaseVO{" + "start=" + start + ", limit=" + limit + '}';
	}
}
