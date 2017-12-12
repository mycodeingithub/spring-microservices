package example.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SpringBootMvcPocApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcPocApplication.class, args);
	}
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message", "welcome to amazing world....");
		return "/welcome";
	}
	
}
