package com.cstech.cwanime.bean;

import org.apache.ibatis.session.RowBounds;

/**
 * 分页参数
 * @author Satsuki
 * @date 2019-03-13
 */
public class PageRowBounds extends RowBounds {

	private Long total;

//	private PageInfo pageInfo;
//
//	public PageRowBounds( PageInfo pageInfo ) {
//		super( pageInfo.getStart(), pageInfo.getLimit() );
//		this.pageInfo = pageInfo;
//	}

	public PageRowBounds( int offset, int limit ) {
		super( offset, limit );
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal( Long total ) {
		this.total = total;
	}

//	public PageInfo getPageInfo() {
//		return this.pageInfo;
//	}
//
//	public void setPageInfo( PageInfo pageInfo ) {
//		this.pageInfo = pageInfo;
//	}
}
