package com.sktechx.oauth;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.sktechx.oauth.config.PropertiesConfig;

//아래 어노테이션들은 @SpringBootApplication 을 선언함으로써 생략이 가능하다...
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan

@SpringBootApplication
@EnableConfigurationProperties(value = { PropertiesConfig.class })
public class Application implements CommandLineRunner {

	/* HTTP 사용을 위한 설정 시작 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);

		return connector;
	}
	/* HTTP 사용을 위한 설정 끝 */


	/* Command Line 출력 */
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("=========== CommandLineRunner::run()");
		for (String arg : arg0) {
			System.out.println("\targ : " + arg);
		}
		System.out.println("=========== System.getProperties() : " + System.getProperties());

	}

	/* argument 출력 */
	// @Override
	// public void run(ApplicationArguments arg0) throws Exception {
	// System.out.println(arg0);
	// }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
