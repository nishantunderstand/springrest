package restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	/**	
	@RequestMapping(method = RequestMethod.GET,path = '/hello-world') 
		WRONG
			' -> Represent Character 
			" -> Represent String 
		
	@RequestMapping("/hello-world") 
		This is Mapping to All GET-POST-PUT-PATCH-DELETE
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping("/hello-world")
	*/
	
	@GetMapping(path = "/")
	public String welcome() {
		return "Welcome to Day One of Spring Project";
	}
	
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
		return new HelloWorldBean("HelloWorld Path Variable : " + name);
	}
	
	
	@GetMapping(path = "/hello-world/path-variable1/{name}")
	public HelloWorldBean helloworldbeanPathVariableName1(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Path Variable %s", name));
	}
}