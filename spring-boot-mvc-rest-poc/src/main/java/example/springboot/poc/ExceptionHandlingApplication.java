package example.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExceptionHandlingApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExceptionHandlingApplication.class, args);
	}

	@RequestMapping("/testMe")
	public String exceptionTesting() {
		//int intVal = Integer.valueOf("a");
		throw new NullPointerException();
		//return "";
	}

	// This is controller level exception handler and not global exception handler
	// @ExceptionHandler(NumberFormatException.class)
	// public void handleException(Exception e) throws CustomException {
	// throw new CustomException(e.getMessage(), e.getCause(), true);
	// }

}

class CustomException {

	private String errorCode;
	private String errorMessage;
	private boolean retry;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isRetry() {
		return retry;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}
}

@ControllerAdvice
class RestExceptionResolver{
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<CustomException> customExceptionHandler(Exception e) {
		
		CustomException response = new CustomException();
        response.setErrorCode("Internal server error...");
        response.setErrorMessage("Someting Went Wrong...");
        response.setRetry(true);
 
        return new ResponseEntity<CustomException>(response, HttpStatus.NOT_FOUND);
		
	}
}
