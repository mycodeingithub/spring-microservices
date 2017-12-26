package com.infomover.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class EmployeeZuulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeZuulClientApplication.class, args);
	}

	@Bean
	public EmployeeZuulFilter employeeZuulFilter() {
		return new EmployeeZuulFilter();
	}
}
