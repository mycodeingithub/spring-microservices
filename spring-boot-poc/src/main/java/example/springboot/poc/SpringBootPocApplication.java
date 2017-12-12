package example.springboot.poc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * @author Karthik Kamarthi
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(BarProperties.class)
public class SpringBootPocApplication {
	
	@Autowired
	private BarProperties barProperties;
	
	@Value("${demo.property}")
	private  String demoProperty;
	
	@Autowired
	private DataSource dataSource;
	

	public static void main(String[] args) {		
		SpringApplication app = new SpringApplication(SpringBootPocApplication.class);
        ConfigurableApplicationContext ctx = app.run(args);
        SpringBootPocApplication springBootPocApplication= ctx.getBean(SpringBootPocApplication.class);
        springBootPocApplication.printExternalizeConfig();
        springBootPocApplication.pringTypeSafeProperty();
        springBootPocApplication.printDataSource();
		
	}
	
	private void printExternalizeConfig(){
		System.out.println(demoProperty);
	}
	
	private void pringTypeSafeProperty(){
		System.out.println(barProperties.getValue());
	}
	
	private void printDataSource(){
		System.out.println(dataSource);
	}	
	
}

@ConfigurationProperties("bar")
class BarProperties {
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}


