package restfulwebservices.controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	// OLD Approach

	// Status Code 200 => 201

	// REQUIRMENT : 200 => 201
	// @RequestMapping(path = "/users", method = RequestMethod.POST)
	// Shortcut Annotation

	// REQUIRMENT : Return URI Location
    
    /**
    @PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED) // 200 => 201
	public void createUser(@Valid @RequestBody User user) {
		service.save(user);
	}
    */
    
    
    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

        return ResponseEntity
            .created(location)   // Sets 201 status and Location header
            .body(savedUser);    // Sends saved user as response body
    }

    
    
    
	
    /**
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
	*/



    
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
