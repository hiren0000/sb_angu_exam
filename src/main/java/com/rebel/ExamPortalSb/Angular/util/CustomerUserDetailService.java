package com.rebel.ExamPortalSb.Angular.util;

import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from DB
        User user =  this.userRepo.findByUserName(username);
                 if(user == null)
                 {
                     System.out.println("User not found with this username: " + username);
                     throw new UsernameNotFoundException("User does not exists !!");

                 }

        return user;
    }
}
