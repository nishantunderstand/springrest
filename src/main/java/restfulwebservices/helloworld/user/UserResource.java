package restfulwebservices.helloworld.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {
	
	// Approach 2
	// @Autowired
	private UserDaoService service;
	
	/**
	Why we are writting this ? Do we really need it ?
	 * Approach 1: This constructor is used for dependency injection. 
	 * In Spring framework, dependency injection is a technique whereby one object supplies the dependencies of another object. 
	 * 
	 * Approach 2:
	 * @Autowired Annotation //@Autowired  
	 * We can use Autowiring or Constructor Injection
	 */
	
	// Approach 1
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	/**
	 * // Version 1 of Find One , What If User which you are searching is
	 * undefined @GetMapping("/users/{id}") public User
	 * retrieveAllUsers(@PathVariable int id ){ return service.findOne(id); }
	 */

	@GetMapping("/users/{id}")
	public void retrieveAllUsers(@PathVariable int id) {
		service.DeleteById(id);

	}

	/**
	 * PART 1 // Currently I am getting Status 200 // But I need
	 * 201 @PostMapping("/users") public void creatUser(@RequestBody User user) {
	 * service.save(user); }
	 * 
	 * @return
	 */

	// Part 2
	// When you need HTTP Status Code 201
	/**
	 * @PostMapping("/users") public ResponseEntity<User> creatUser(@RequestBody
	 * User user) { service.save(user); return ResponseEntity.created(null).build();
	 * 
	 * }
	 */

	/**
	 * Part 3 When you need to see location as well
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		// users/4 => /users /id => /users + id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void DeleteById(@PathVariable int id) {
		service.DeleteById(id);
	}

}
