package com.tacazzy.api.controllers;

import com.tacazzy.api.models.User;
import com.tacazzy.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontramos esse usuario!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User u = userService.insert(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/user/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
