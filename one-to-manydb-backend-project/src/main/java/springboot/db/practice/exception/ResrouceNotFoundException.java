package springboot.db.practice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResrouceNotFoundException extends RuntimeException{
	
	
	public ResrouceNotFoundException(String message) {
		super(message);
	}

}
