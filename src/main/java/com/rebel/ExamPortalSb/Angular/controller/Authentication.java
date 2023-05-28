package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.payloads.JwtRequest;
import com.rebel.ExamPortalSb.Angular.payloads.JwtResponse;
import com.rebel.ExamPortalSb.Angular.payloads.JwtUtil;

import com.rebel.ExamPortalSb.Angular.util.CustomerUserDetailService;
import com.rebel.ExamPortalSb.Angular.util.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class Authentication
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    //generate token

    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
    {

        try
        {
            authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());

            System.out.println(jwtRequest.getUserName());
        }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not found ");
        }

        //authenticated user

        UserDetails userDetails = this.customerUserDetailService.loadUserByUsername(jwtRequest.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }




    private void authenticate(String username, String password) throws Exception
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (DisabledException e)
        {
            throw new DisabledException(" USER IS DISABLED ");
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Invalid Credentials "+ e);
        }

    }


    // returning the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return (User)this.customerUserDetailService.loadUserByUsername(principal.getName());
    }
}

