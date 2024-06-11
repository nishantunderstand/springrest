package restfulwebservices.helloworld.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	// 1. Constructor Injection & 2. Autowired Annotation
	// @Autowired
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveAllUsers(@PathVariable int id) {
		return service.findOne(id);
	}

	/** Variation of POST Method	 
	 // 1. I am not returning anything, That doesn't make sense. So I will send some response.In Postman, I am getting Status 200, I am happy with it, But Correct Response is 201.
	 @PostMapping("/users")
	 public void creatUser(@RequestBody User user) {
	 service.save(user);
	 }
	 
	 
	 // 2. Here, I am returning , I need to change return type. Now i am getting Status 201 Which is Created, But i am still not getting confirmation.
	 @PostMapping("/users")
	 public ResponseEntity<User> creatUser(@RequestBody User user) {
	 service.save(user);
	 return ResponseEntity.created(null).build();
	 }
	 
	
	// 3. Now, I want to see the location, where the new User is Created, i.e. Location
	users/4 => /users /id => /users + id
	1 Current Request ,
	2 Adding Id, 
		I need to saved that User, Reason ID is present in that User. I need to Fetch it. 
	3 Replacing ID with my created ID,
	4 Converting to URI
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		System.out.println("location :" + location);
		return ResponseEntity.created(location).build();

	}
}