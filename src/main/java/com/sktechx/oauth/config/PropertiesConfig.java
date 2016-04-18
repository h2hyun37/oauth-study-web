package com.sktechx.oauth.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * TODO : @PropertySource 와 @ConfigurationProperties 의 정확한 차이를 확인해봐야 겠음
 *
 * 일단
 *
 * @PropertySource : Spring MVC
 * @ConfigurationProperties : Spring Boot.
 *
 *
 */

// 아래는 Spring MVC 에서의 설정 방법
// @Configuration
// @PropertySource(value = "classpath:/config/application.properties")

@ConfigurationProperties(locations = { "classpath:/config/application.properties" })
@Data
public class PropertiesConfig {

	// @Value("${auth.domain.full}")
	@Value("tempDomain")
	private String authDomain;

	// @Value("${debug}")
	@Value("tempDebug")
	private String debug;

}
