package com.cstech.cwanime.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SSO 认证入口（Login/Register）
 * @author Satsuki
 */
@ComponentScan(basePackages = {"com.cstech.cwanime.portal", "com.cstech.cwanime"})
@SpringBootApplication
public class CsTechCwAnimePortalApplication {

	public static void main( String[] args ) {
		SpringApplication.run( CsTechCwAnimePortalApplication.class, args );
	}

}
