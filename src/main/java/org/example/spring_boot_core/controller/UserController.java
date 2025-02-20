package org.example.spring_boot_core.controller;

import org.example.spring_boot_core.dto.request.UserRequest;
import org.example.spring_boot_core.dto.request.UserUpdateRequest;
import org.example.spring_boot_core.entity.User;
import org.example.spring_boot_core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    User addUser(@RequestBody UserRequest request) {
        return  userService.createRequest(request);
    }

    @GetMapping()
    List<User> getUsers() {
        return  userService.findAll();
    }

    @GetMapping("{id}")
    User getUser(@PathVariable("id") String id) {
        return userService.findUser(id);
    }

    @PutMapping("{id}")
    User updateUser(@PathVariable("id") String id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("{id}")
    String  deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return  "User has been deleted";
    }

}
