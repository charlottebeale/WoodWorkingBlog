package web.name.placeholder.controller;

import web.name.placeholder.models.User;
import web.name.placeholder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        Iterable<User> list = service.findAll();
        for(User u : list)
            if(u.getUsername().equals(user.getUsername()))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @Valid @RequestBody User user){
        return new ResponseEntity<>(service.updateUser(username, user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Boolean> deleteUser(@RequestParam String username){
        return new ResponseEntity<>(service.deleteByUsername(username), HttpStatus.OK);
    }

}
