package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.Role;
import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.models.UserRole;
import com.rebel.ExamPortalSb.Angular.service.UserService;
import com.rebel.ExamPortalSb.Angular.util.ApiRepsonse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users/")

public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //creating user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        Set<UserRole> roles = new HashSet<>();

        //Encoding password will enable it later :
        //this.bCryptPasswordEncoder.encode(user.getPassword());

        //USER must be normal user through the Registration 
        Role role = new Role(45, "NORMAL");

        roles.add(new UserRole(user, role));

        return new ResponseEntity<>(this.userService.createUser(user, roles), HttpStatus.OK);
    }

    //update user
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
       return new ResponseEntity<>( this.userService.updateUser(user), HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiRepsonse> deleteUser(@PathVariable Integer id)
    {
        return new ResponseEntity<>(new ApiRepsonse("User delete successfully with userId"+" "), HttpStatus.OK);
    }


    //get user by username
    @GetMapping("/{userName}")
    public User getUser(@PathVariable  String userName)
    {
        return this.userService.getUser(userName);
    }



}
