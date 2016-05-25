package com.h2hyun37;

import lombok.Data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotationTest {

	@Data
	public class StringVO {

		String value;

	}

	@Bean
	public StringVO userNameMethod() {

		System.out.println("userNameMethod() called");

		StringVO stringVO = new StringVO();
		stringVO.setValue("userNameMethod String VO!!!");

		return stringVO;
	}

	@Bean
	public StringVO userName() {

		System.out.println("userName() called");

		StringVO stringVO = new StringVO();
		stringVO.setValue("userName String VO!!!");

		return stringVO;
	}

}
