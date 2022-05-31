package com.tacazzy.api.controllers;

import com.tacazzy.api.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public ResponseEntity<User> hello() {
        User user = new User(1L, "Maria", "Maria@gmail.com", "14988383021", "20272");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
