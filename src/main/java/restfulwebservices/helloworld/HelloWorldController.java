package restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * Wrong @RequestMapping(method = RequestMethod.GET,path = '/hello-world')
 * I am not understand String.format is the Issue,
 * ' -> Represent Character 
 * " -> Represent String 
 */


/**
 * Can we use @Controller instead of @RestController ?
 * {@link }
 */
@RestController
public class HelloWorldController {

	// 1. Old Approach
	// @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	// 2. New Approach
	 @GetMapping(path = "/hello-world")
	public String helloworld() {
		return "HelloWorld Returning String";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("HelloWorld Returning Bean");
	}
	
	/**
	 * How to bind the variable that is send from URL.
	 * URL -> Java Application --> Frontend
	 */
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldbeanPathVariableName(@PathVariable String name) {
		
		// return new HelloWorldBean("HelloWorld Path Variable : " + name);
		return new HelloWorldBean(String.format("HelloWorld Returning Bean From Path Variable %s", name)) ;
	}
}
