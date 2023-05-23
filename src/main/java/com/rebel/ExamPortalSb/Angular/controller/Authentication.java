package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.util.ApiRepsonse;
import com.rebel.ExamPortalSb.Angular.util.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users/")
public class Authentication
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ResponseEntity<ApiRepsonse> userLog(@RequestBody Logging login) throws Exception
    {
        authenticate(login.getUserName(), login.getPassword());
        return new ResponseEntity<ApiRepsonse>(new ApiRepsonse("Logged in successfully"), HttpStatus.OK);
    }


    //authentication manager
    private void authenticate(String email, String password) throws Exception
    {
        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }
        catch(Exception e)
        {
            throw new Exception("Bad Credential"+ e);
        }

    }


}
