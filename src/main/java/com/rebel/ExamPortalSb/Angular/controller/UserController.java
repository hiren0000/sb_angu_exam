package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.Role;
import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.models.UserRole;
import com.rebel.ExamPortalSb.Angular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController
{
    @Autowired
    private UserService userService;


    //creating user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        Set<UserRole> roles = new HashSet<>();

        //USER must be normal user through the Registration 
        Role role = new Role(45, "NORMAL");

        roles.add(new UserRole(user, role));

        return new ResponseEntity<>(this.userService.createUser(user, roles), HttpStatus.CREATED);
    }



}
