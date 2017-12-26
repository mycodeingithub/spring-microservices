package example.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HttpEntityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpEntityPocApplication.class, args);
	}
	
	@RequestMapping(value="/getCity", method=RequestMethod.GET)
	public @ResponseBody HttpEntity<OutputData> getMyCity() {
		OutputData outputData = new OutputData();
		outputData.setCity("Hyderabad");
		
		
		HttpHeaders headers = new HttpHeaders();
	    headers.set("testHeader", "Test Header");
	    
		HttpEntity<OutputData> httpEntity = new HttpEntity<>(outputData, headers);
		return httpEntity;
		
	}

}
