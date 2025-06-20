package restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Step 2: Error Code 501--> 404
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException_2024 extends RuntimeException {

	public UserNotFoundException_2024(String message) {
		super(message);
	}

}
