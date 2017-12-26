package example.springcloud.poc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@RibbonClient(name = "ribbonClient")
public class EmployeeRibbonClientApplication {
	
	private static final Log log = LogFactory.getLog(EmployeeRibbonClientApplication.class);
	
	 @Autowired
	 private LoadBalancerClient loadBalancer;
	 
	 private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRibbonClientApplication.class, args);
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(@RequestBody Object userEntity) {
		ServiceInstance instance = loadBalancer.choose("employee-eureka-client");
        String url = instance.getUri().toString()+"/createUser";
        System.out.println("URL is:..."+url);
        return restTemplate.postForEntity(url, userEntity, String.class).getBody();
	}
	
	
	@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
	public Iterable<Object> getAllUsers() {
		log.info("Employee Ribbon request");
		ServiceInstance instance = loadBalancer.choose("employee-eureka-client");
        String url = instance.getUri().toString()+"/getAllUsers";
        System.out.println("URL is:..."+url);
        return restTemplate.getForEntity(url, Iterable.class).getBody();
	}
	
	@RequestMapping(value="/getUser/{id}", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "userNotFound")
	public Object getUsers(@PathVariable(value="id") String id) {
		log.info("Employee Ribbon request");
		ServiceInstance instance = loadBalancer.choose("employee-eureka-client");
        String url = instance.getUri().toString()+"/getUser/"+id;
        System.out.println("URL is:..."+url);
        return restTemplate.getForEntity(url, Object.class).getBody();
	}
	
	
	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "getDefaultName")
    public String getName() {
		log.info("Employee Ribbon request");
		ServiceInstance instance = loadBalancer.choose("employee-eureka-client");
        String url = instance.getUri().toString()+"/hello";
        System.out.println("URL is:..."+url);
        return restTemplate.getForEntity(url, String.class).getBody();
    }
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "getDefaultName")
    public String getName(@PathVariable String name) {
		log.info("Employee Ribbon request");
		ServiceInstance instance = loadBalancer.choose("employee-eureka-client");
        String url = instance.getUri().toString()+"/hello-again/"+name;
        System.out.println("URL is:..."+url);
        return restTemplate.getForEntity(url, String.class).getBody();
    }
	
	public String getDefaultName() {
		return "This is default name";
	}
	
	public String getDefaultName(String name) {
		return "Default hello to: "+name;
	}
	
	public String userNotFound(String id) {
		return "User with id="+id+" not found";
	}
}
