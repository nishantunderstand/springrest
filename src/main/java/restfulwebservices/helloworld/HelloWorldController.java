package restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Can we use @Controller instead of @RestController ?
@RestController

public class HelloWorldController {
	
	/**	
	Wrong @RequestMapping(method = RequestMethod.GET,path = '/hello-world')
	I am not understand String.format is the Issue,
	' -> Represent Character 
	" -> Represent String 
	
	1. Old Approach
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	2. New Approach
	
	*/
	
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World Bean");
	}

	
	/**
	 * How to bind the variable that is send from URL.
	 * URL -> Java Application --> Frontend
	 */
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldbeanPathVariableName(@PathVariable String name) {
		// return new HelloWorldBean("HelloWorld Path Variable : " + name);
		return new HelloWorldBean(String.format("Hello World Path Variable %s", name));
	}
}