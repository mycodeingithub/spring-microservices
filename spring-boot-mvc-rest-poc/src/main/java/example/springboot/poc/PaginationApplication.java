package example.springboot.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@SpringBootApplication
public class PaginationApplication extends WebMvcConfigurerAdapter{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}
	
	@RequestMapping("listEmployees")
	public Page<EmployeeEntity> listEmployees(Pageable pageable){
		if(!(employeeRepository.count() > 0))
		for(int i =0;i<=20; i++) {
			employeeRepository.save(new EmployeeEntity());
		}
		return employeeRepository.findAll(pageable);
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

@Repository
interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, String>{
	
}
