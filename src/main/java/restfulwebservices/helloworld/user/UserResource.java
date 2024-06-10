package restfulwebservices.helloworld.user;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserResource {
	
	// 1. Constructor Injection & 2. Autowired Annotation 
	//@Autowired
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
	
	*/
	// 2. Here, I am returning , I need to change return type. Now i am getting Status 201 Which is Created, But i am still not getting confirmation.
	@PostMapping("/users")
	public ResponseEntity<User> creatUser(@RequestBody User user) {
		service.save(user);
		return ResponseEntity.created(null).build(); 
	}
	
	
	
	}