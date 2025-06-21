package restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import restfulwebservices.dao.UserDaoService;
import restfulwebservices.exception.UserNotFoundException;
import restfulwebservices.model.User;

@RestController
public class UserResourceController {

    // 1. Constructor Injection 
    // 2. Autowired Annotation
	
    @Autowired
    private UserDaoService service;

    public UserResourceController(UserDaoService service) {
        this.service = service;
    }

	// CREATE
	// Fluent Builder Approach
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		System.out.println("location :" + location);
		return ResponseEntity
			.created(location)
				.build();
	}

    
	// Read One
    @GetMapping("/users/{id}")
	public User retrieveOneUsers(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }

	// Read-All
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// Delete
    @DeleteMapping("/users/{id}")
    public void DeleteById(@PathVariable int id) {
        service.DeleteById(id);
    }
}
