package example.springcloud.poc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.springcloud.poc.entity.UserEntity;
import example.springcloud.poc.service.UserService;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class EmployeeEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEurekaClientApplication.class, args);
	}

}

@RestController
class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@RequestBody UserEntity userEntity) {
		userService.createUser(userEntity);
		return "User Created Successfully";
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public Iterable<UserEntity> getAllUsers() {
		System.out.println(this);
		return userService.getAllUser();
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public UserEntity getUsers(@PathVariable("id") String id) {
		return userService.get(id);
	}
}

@RestController
class ServiceInstanceRestController {

	private static final Log log = LogFactory.getLog(EmployeeEurekaClientApplication.class);
	
//	@Value("${foo}")
//	private String someValue;

	@RequestMapping("/hello")
	public String hello() throws InterruptedException {
		//hit http://localhost:<port>/hello --> port no will generate dynamically, get from the console
		log.info("Employee hello request");
		System.out.println("This....." + this);
		return "Hello....";
	}

	@RequestMapping("/hello-again/{name}")
	public String hello(@PathVariable String name) {
		log.info("Employee hello request");
		return "hello " + name + "....";
	}

}
