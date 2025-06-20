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

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // User Id Version 1
    @GetMapping("/users/{id}")
    public User retrieveAllUsers1(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }

    /**
     * 1. I am not returning anything, That doesn't make sense. So I will send
     * some response. In Postman, I am getting Status 200. I am happy with it,
     * But Correct Response is 201.
     */
    @PostMapping("/users")
    public void creatUser(@RequestBody User user) {
        service.save(user);
    }

    /**
     * 2. Here, I am returning , I need to change return type. Now i am getting
     * Status 201 Which is Created, But i am still not getting confirmation.
     */
    @PostMapping("/users1")
    public ResponseEntity<User> creatUser1(@RequestBody User user) {
        service.save(user);
        return ResponseEntity.created(null).build();
    }

    /**
     * 3. Now, I want to see the location, where the new User is Created, i.e.
     * Location users/4 => /users /id => /users + id 1 Current Request , 2
     * Adding Id, I need to saved that User, Reason ID is present in that User.
     * I need to Fetch it. 3 Replacing ID with my created ID, 4 Converting to
     * URI
     */
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        System.out.println("location :" + location);
        return ResponseEntity.created(location).build();
    }

    // 4. Can we apply Validation on User , Yes we can, By using @valid annotation.
    @PostMapping("/users1")
    public ResponseEntity<User> createUser1(@Valid @RequestBody User user) {

        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        System.out.println("location :" + location);
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void DeleteById(@PathVariable int id) {
        service.DeleteById(id);
    }
}
