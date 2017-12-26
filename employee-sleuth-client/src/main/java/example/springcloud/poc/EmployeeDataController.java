package example.springcloud.poc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeDataController {
	
	private static final Log log = LogFactory.getLog(EmployeeDataController.class);
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(path="/hello")
	public String getEmployeeData() {
		log.info("Employee hello request");
		
		return restTemplate.getForObject("http://localhost:8090/employees/hello", String.class);
	}
	

}

@RestController
class EmployeeDataController1 {
	
	private static final Log log = LogFactory.getLog(EmployeeDataController.class);
	
	@RequestMapping(path="/getEmployeeData1")
	public String getEmployeeData() {
		log.info("Employee data request1");
		return "Emplooyee Data1";
	}
	

}
