package com.rebel.ExamPortalSb.Angular.repo;

import com.rebel.ExamPortalSb.Angular.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
   public User findByUserName(String username);
}
