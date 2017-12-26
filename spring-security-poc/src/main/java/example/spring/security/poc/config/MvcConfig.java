package example.spring.security.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/registration").setViewName("registration");
		registry.addViewController("/login").setViewName("login");
	}

}