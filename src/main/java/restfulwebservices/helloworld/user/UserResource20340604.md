package restfulwebservices.helloworld.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource20340604 {

	
	


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
