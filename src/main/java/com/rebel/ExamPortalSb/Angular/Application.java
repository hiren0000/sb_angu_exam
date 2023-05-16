package com.rebel.ExamPortalSb.Angular;

import com.rebel.ExamPortalSb.Angular.models.Role;
import com.rebel.ExamPortalSb.Angular.models.User;
import com.rebel.ExamPortalSb.Angular.models.UserRole;
import com.rebel.ExamPortalSb.Angular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Code started");

	/*	User user = new User();
		user.setUserName("hiru");
		user.setFirstName("Hiren");
		user.setLastName("Dev");
		user.setEmail("1@g.com");
		user.setPassword("1245");

		Role role1 = new Role(44, "ADMIN");

		Set<UserRole> userRolesSet = new HashSet<>();

		UserRole userRoles = new UserRole(user, role1);

		userRolesSet.add(userRoles);

		User createdUser = this.userService.createUser(user, userRolesSet);

		System.out.println(createdUser.getUserName());
*/



	}
}
