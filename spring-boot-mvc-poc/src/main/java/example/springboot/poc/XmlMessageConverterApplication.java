package example.springboot.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
public class XmlMessageConverterApplication extends WebMvcConfigurerAdapter {
	
	@Autowired
	MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter;

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2XmlHttpMessageConverter);
		super.configureMessageConverters(converters);
	}

	@RequestMapping("/getEmployee")
	public Person getEmployee() {
		return new Person("Enterprise", "Java");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(XmlMessageConverterApplication.class, args);
	}
}

class Person {
	private String name;
	private String lastName;
	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

}
