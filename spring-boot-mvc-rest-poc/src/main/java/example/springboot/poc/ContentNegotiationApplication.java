package example.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@SpringBootApplication
public class ContentNegotiationApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ContentNegotiationApplication.class, args);
	}

	@RequestMapping(value = "/employee/{id}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable long id) {
		return new Employee().setName("Karthik").setLastName("Kamarthi").setId(id);
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	
	    configurer.favorPathExtension(true).
	            favorParameter(true).
	            parameterName("mediaType").
	            ignoreAcceptHeader(false).
	            useJaf(false).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);   
	}
	
}
