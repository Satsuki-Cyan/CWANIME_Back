package com.cstech.cwanime.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 跨域CORS
 * @author Satsuki.Cyan
 * @date 2019-04-04 10:15:23
 */
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin( "*" );
		corsConfiguration.addAllowedHeader( "*" );
		corsConfiguration.addAllowedMethod( "*" );
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration( "/**", buildConfig() );
		return new CorsFilter( source );
	}
}
