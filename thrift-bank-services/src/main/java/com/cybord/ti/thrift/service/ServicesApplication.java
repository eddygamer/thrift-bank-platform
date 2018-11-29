package com.cybord.ti.thrift.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author eddyrs
 *
 */
@SpringBootApplication
public class ServicesApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServicesApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}
	
}
