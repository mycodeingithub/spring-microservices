package example.spring.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To Access resource : POST - localhost:8080 with header Authentication : Bearer: <Access-TOKEN>
 *
 */
@SpringBootApplication
@EnableResourceServer
@RestController
public class OAuth2PasswordResourceServerApplication extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2PasswordResourceServerApplication.class, args);
	}
	
	@RequestMapping
	public String greeting() {
		return "Hello World";
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			// Just for laughs, apply OAuth protection to only 2 resources
			.requestMatchers().antMatchers("/**")
			.and()
			.authorizeRequests()
			.anyRequest().access("#oauth2.hasScope('read')")
			.and().csrf().disable();
		// @formatter:on
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources)
			throws Exception {
		resources.resourceId("myResource");
	}
	
	@Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:8085/oauth/check_token");
        tokenService.setClientId("user123");
        tokenService.setClientSecret("password123");
        return tokenService;
    }
}
