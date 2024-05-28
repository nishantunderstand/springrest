package restfulwebservices.helloworld.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Why Runtime, Whyn't Normal Exception
 * Ranga : Want to Avoid Checked Exception
 * Reason : I don't understand
 */

/**
@ResponseStatus(code = HttpStatus.NOT_FOUND)
1. Status 500 Without this code
2. Status 404 With this code  
*/
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	/**
	 * Why serialVersionUID : This is used to track file
	 */
	private static final long serialVersionUID1 = -8839076943844028562L;
	
	
	public UserNotFoundException(String message) {
		super(message);		
	}
}
