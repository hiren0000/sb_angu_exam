package com.rebel.ExamPortalSb.Angular.service.ServiceImpl;

import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.models.UserRole;
import com.rebel.ExamPortalSb.Angular.repo.RoleRepo;
import com.rebel.ExamPortalSb.Angular.repo.UserRepo;
import com.rebel.ExamPortalSb.Angular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User local = this.userRepo.findByUserName(user.getUserName());

        if(local != null)
        {
            System.out.println("User is already exist !!");

            try {
                throw new Exception("User already present");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            //get each userRole
            for(UserRole ur: userRoles)
            {
                roleRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);


        }

        return local;
    }
}
