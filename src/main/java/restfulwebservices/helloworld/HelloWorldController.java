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

@RestController
public class HelloWorldController {
	// @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "HelloWorld!!!123333-TRY NEW AND TRY AGAIN";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("HelloWorld!!!123333bean");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldbeanPathVariableName(@PathVariable String name) {
		// return new HelloWorldBean("HelloWorld Path Variable : " + name);
		return new HelloWorldBean(String.format("Aman1111 +++--- %s", name)) ;
	}
}
