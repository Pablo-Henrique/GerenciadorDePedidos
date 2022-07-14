package com.tacazzy.api.controllers;

import com.tacazzy.api.exceptions.ex.ResourceNotFoundException;
import com.tacazzy.api.models.User;
import com.tacazzy.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User u = userService.insert(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/user/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @Transactional
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userService.deleteById(user.getId());
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable(value = "id") Long id, @RequestBody User newUser) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        User entity = userService.update(id, newUser);
        return ResponseEntity.ok().body(entity);
    }

}
