package com.nt.app.controllers.dashboard;

import com.nt.app.persistence.jpadao.UserRepository;
import com.nt.app.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> store(@Valid @RequestBody User user) {
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public User edit(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @PutMapping
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        if(user != null) {
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        if(user != null) {
            userRepository.delete(user);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}