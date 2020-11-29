package com.mustafa.bootstrap;

import com.mustafa.dto.ProjectDTO;
import com.mustafa.dto.RoleDTO;
import com.mustafa.dto.UserDTO;
import com.mustafa.enums.Gender;
import com.mustafa.enums.Status;
import com.mustafa.services.ProjectService;
import com.mustafa.services.RoleService;
import com.mustafa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Mike","Smith","email@testemail.com","1234567890","Abc1",true,adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Tom","Sawyer","TestEmail@email.com","7894561230","Abc1",true,managerRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Nezaro","Xiro","nezaroxiro@gmail.com","6157894562","Abc1",true,managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Grandpa","Apo","grandpa@gmail.com","4156879452","Abc1",true,employeeRole, Gender.FEMALE);
        UserDTO user5 = new UserDTO("Ozzy","Dev","thisistest@testemail.com","3514786925","Abc1",true,employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

        ProjectDTO project1 = new ProjectDTO("PR001","Ticketing Project",user2, LocalDate.now(),LocalDate.now().plusMonths(2),"This is testng project", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("PR007","Best Practices",user3, LocalDate.now().minusMonths(1),LocalDate.now().plusMonths(1),"Cucumber Project", Status.COMPLETED);
        ProjectDTO project3 = new ProjectDTO("PR005","Example Project",user1, LocalDate.now().minusWeeks(3),LocalDate.now().plusWeeks(5),"SDET to BackEnd Engineer", Status.IN_PROGRESS);
        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);


    }
}
