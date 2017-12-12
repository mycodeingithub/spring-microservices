package example.springboot.poc;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Karthik Kamarthi
 * The annotation @ConfigurationProperties("bar") reads the configuration from application properties. 
 * The instance variable name should be same as mentioned in the property.
 *
 */
@ConfigurationProperties("bar")
public class BarProperties {
	
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
