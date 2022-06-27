package com.example.project_dbb.Controller;

import com.example.project_dbb.Entity.User;
import com.example.project_dbb.Opportunities.UserOpportunities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserOpportunities userOpportunities;

    @Autowired
    public UserController(UserOpportunities userOpportunities) {
        this.userOpportunities = userOpportunities;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userOpportunities.getAllUser();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/userId")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = userOpportunities.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delUser")
    public ResponseEntity<Long> delUserById(@PathVariable long id) {
        userOpportunities.delUserById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody  User user) {
        userOpportunities.addUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
