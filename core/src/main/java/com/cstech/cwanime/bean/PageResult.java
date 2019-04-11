package com.cstech.cwanime.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author Satsuki
 * @param <E>
 */
public class PageResult<E> implements Serializable {

	private Long total;

	private List<E> rows;

	public PageResult() {}

	public PageResult( Long total, List<E> rows ) {
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal( Long total ) {
		this.total = total;
	}

	public List<E> getRows() {
		return this.rows;
	}

	public void setRows( List<E> rows ) {
		this.rows = rows;
	}
}
