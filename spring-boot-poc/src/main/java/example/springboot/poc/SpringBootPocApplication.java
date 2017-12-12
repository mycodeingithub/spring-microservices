package example.springboot.poc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * @author Karthik Kamarthi
 * Basic Spring Boot Application reads property from application properties.
 * You can find out 3 ways of retrieving the configuration values.
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(BarProperties.class)
public class SpringBootPocApplication {
	
	@Value("${demo.property}")
	private  String demoProperty;
	
	@Autowired
	private BarProperties barProperties;
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(SpringBootPocApplication.class);
        ConfigurableApplicationContext ctx = app.run(args);
        
        SpringBootPocApplication springBootPocApplication= ctx.getBean(SpringBootPocApplication.class);
        System.out.println(springBootPocApplication.getDemoProperty());
        System.out.println(springBootPocApplication.getBarProperties().getValue());
        System.out.println(springBootPocApplication.getDataSource());
		
	}
	
	public String getDemoProperty() {
		return demoProperty;
	}

	public BarProperties getBarProperties() {
		return barProperties;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}