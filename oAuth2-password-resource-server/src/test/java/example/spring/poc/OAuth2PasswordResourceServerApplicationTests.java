package example.spring.poc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2PasswordResourceServerApplicationTests {

	@Test
	public void testPasswordGrant() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("user");
		resourceDetails.setPassword("password");
		resourceDetails.setAccessTokenUri("http://localhost:8085/oauth/token");
		resourceDetails.setClientId("user123");
		resourceDetails.setClientSecret("password123");
		resourceDetails.setGrantType("password");

		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);

		final String greeting = restTemplate.getForObject("http://localhost:8086/",
				String.class);

		Assert.assertEquals("Hello World", greeting);
	}

}
