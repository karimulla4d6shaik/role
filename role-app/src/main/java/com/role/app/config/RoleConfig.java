package com.role.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
