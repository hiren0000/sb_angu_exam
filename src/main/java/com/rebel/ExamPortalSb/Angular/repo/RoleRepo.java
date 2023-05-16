package com.rebel.ExamPortalSb.Angular.repo;

import com.rebel.ExamPortalSb.Angular.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>
{

}
