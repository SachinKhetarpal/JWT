package com.sachinkhetarpal.jwt.controller;

import com.sachinkhetarpal.jwt.model.Role;
import com.sachinkhetarpal.jwt.model.User;
import com.sachinkhetarpal.jwt.model.UserRole;
import com.sachinkhetarpal.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        roles.add(new UserRole(null,user,role));

        return this.userService.createUser(user,roles);
    }


    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return this.userService.getUserByUsername(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }
}
