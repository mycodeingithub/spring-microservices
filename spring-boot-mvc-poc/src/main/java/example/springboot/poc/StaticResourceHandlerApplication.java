package example.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
public class StaticResourceHandlerApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(StaticResourceHandlerApplication.class, args);
	}

	//access is via localhost:8080/img/* . e.g., localhost:8080/img/image.JPG
	@Bean
	WebMvcConfigurer configurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
			}
		};
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
		

}
