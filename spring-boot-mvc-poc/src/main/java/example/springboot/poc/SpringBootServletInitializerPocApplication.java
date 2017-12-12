package example.springboot.poc;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
///*
// * TO run Spring boot app as war file:
// * 1) Extend SpringBootServletInitializer and override configure method
// * 2) add <dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-tomcat</artifactId>
//			<scope>provided</scope>
//		</dependency>
//	3) Convert <packaging>war</packaging>
//	4) Deploy war file on tomcat running on your machine
// */
//@SpringBootApplication
//@RestController
//public class SpringBootServletInitializerPocApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootServletInitializerPocApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(SpringBootServletInitializerPocApplication.class);
//	}
//	
//	@RequestMapping
//	public String welcome() {
//		return "welcome";
//	}
//	
//
//}
