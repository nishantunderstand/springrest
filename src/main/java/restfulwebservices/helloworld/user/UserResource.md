package restfulwebservices.helloworld.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// Find One ,What If User which you are searching is undefined
	@GetMapping("/users/{id}")
	public User retrieveAllUsers(@PathVariable int id) {
		return service.findOne(id);
	}

	@GetMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		service.DeleteById(id);

	}

	// PART 1 Currently I am getting Status 200 , But I need 201 
	  @PostMapping("/users")
	   public void creatUser(@RequestBody User user) {
		 service.save(user);
	   }

	  /**
	  
	// Part 2 ,When you need HTTP Status Code 201
	 @PostMapping("/users") 
	 public ResponseEntity<User> creatUser(@RequestBody User user) { 
	 service.save(user); 
	 return ResponseEntity.created(null).build();
	 }

	 
	// Part 3 When you need to see location as well
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		// users/4 => /users /id => /users + id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	*/
	  
	@DeleteMapping("/users/{id}")
	public void DeleteById(@PathVariable int id) {
		service.DeleteById(id);
	}

}
