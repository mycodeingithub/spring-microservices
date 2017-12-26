package example.springcloud.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@RefreshScope
public class ConfigClientApplication {

	@Value("${foo}")
	private String someValue;
	
	public ConfigClientApplication() {
		System.out.println(someValue);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@GetMapping("/hello")
	public @ResponseBody String hello() {
		return someValue; //http://localhost:8080/hello
	}
}
