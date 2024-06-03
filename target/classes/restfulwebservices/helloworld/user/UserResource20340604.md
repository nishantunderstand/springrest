package restfulwebservices.helloworld.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource20340604 {

	private UserDaoService service;

	public UserResource20340604(UserDaoService service) {
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

	

	// PART 1 Currently I am getting Status 200 , But I need 201, Remove SubScript
	@PostMapping("/users")
	public void creatUser1(@RequestBody User user) {
		service.save(user);
	}
	
	/**
	// Part 2 ,When you need HTTP Status Code 201, Remove Subscript
	@PostMapping("/users")
	public ResponseEntity<User> creatUser2(@RequestBody User user) {
		service.save(user);
		return ResponseEntity.created(null).build();
	}

	// Part 3 When you need to see location as well, Remove Subscript
	@PostMapping("/users")
	public ResponseEntity<User> createUser3(@RequestBody User user) {
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
	
	
	/**
	@GetMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		service.DeleteById(id);

	}
	*/

}
