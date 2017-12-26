package example.spring.security.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.spring.security.poc.entity.User;
import example.spring.security.poc.service.UserService;

@Controller
public class SampleController {
	
	@Autowired
    private UserService userService;

	
	@GetMapping("/userData")
	public @ResponseBody String getUserData() {
		return "This is User Data";
	}
	

	@GetMapping("/adminData")
	public @ResponseBody String getAdminData() {
		return "This is Admin Data";
	}
	
	
	@PostMapping(value = "/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/welcome";
    }
	
	

}
