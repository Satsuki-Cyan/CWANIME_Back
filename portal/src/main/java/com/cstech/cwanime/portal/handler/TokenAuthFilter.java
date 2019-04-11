package com.cstech.cwanime.portal.handler;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cstech.cwanime.service.RedisService;

/**
 * 请求过滤 - 验证token是否有效
 * @author Satsuki.Cyan
 * @date 2019-04-01 10:50:23
 */
@Component
@WebFilter( urlPatterns = "/*", filterName = "tokenAuthFilter" )
@Order( 1 )
public class TokenAuthFilter implements Filter {

	private static Logger LOGGER = LoggerFactory.getLogger( TokenAuthFilter.class );

	@Override
	public void init( FilterConfig filterConfig ) throws ServletException {

	}

	@Override
	public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = ( HttpServletRequest )servletRequest;

		// 从header获取token
		String token = httpServletRequest.getHeader( "token" );
		if( StringUtils.isEmpty( token ) ) {
			// 非法请求，未查询到header信息
			LOGGER.info( "request can't get header info" );
			return;
		}

		// 获取 servlet上下文
		ServletContext sc = httpServletRequest.getSession().getServletContext();
		// 获取 spring 容器
		AbstractApplicationContext cxt = ( AbstractApplicationContext )WebApplicationContextUtils.getWebApplicationContext( sc );

		RedisService redisService = ( RedisService )cxt.getBean( "redisService" );

		String redisValue = redisService.get( token );
		if( StringUtils.isEmpty( redisValue ) ) {
			// 未查询到登录信息或没有足够的权限，返回错误信息（跳转至登录页？还是提示未登录）
			LOGGER.info( "user have no enough auth or not sign in" );
			return;
		}

		filterChain.doFilter( servletRequest, servletResponse );
	}

	@Override
	public void destroy() {

	}
}
