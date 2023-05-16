package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService
{
    //creating user
    public User createUser(User user, Set<UserRole> userRoles);

}
