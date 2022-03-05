package com.mustafa.bootstrap;

import com.mustafa.dto.ProjectDTO;
import com.mustafa.dto.RoleDTO;
import com.mustafa.dto.UserDTO;
import com.mustafa.entity.Role;
import com.mustafa.enums.Gender;
import com.mustafa.enums.Status;
import com.mustafa.implementations.RoleServiceImpl;
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

    @Autowired
    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }




    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Mike","Smith","email@testemail.com","1234567890",true,"1549138841",adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Tom","Sawyer","TestEmail@email.com","7894561230",true,"8751397421",managerRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Nezaro","Xiro","nezaroxiro@gmail.com","6157894562",true,"6423785133",managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Grandpa","Apo","grandpa@gmail.com","4156879452",true,"6465768980343",employeeRole, Gender.FEMALE);
        UserDTO user5 = new UserDTO("Ozzy","Dev","thisistest@testemail.com","3514786925",true,"46376586980",employeeRole, Gender.FEMALE);
        UserDTO user6 = new UserDTO("Mustafa","Kara","mustafa@gmail.com","1234567890",true,"2155562615",adminRole, Gender.MALE);
        UserDTO user7 = new UserDTO("Tom","Hanks","hanks@email.com","44757856786",true,"756866886",managerRole, Gender.MALE);
        UserDTO user8 = new UserDTO("Metz","Dona","jpg@gmail.com","6157894562",true,"6423785133",managerRole, Gender.FEMALE);
        UserDTO user9 = new UserDTO("Gurt","Admon","admon@gmail.com","4156879452",true,"6465768980343",employeeRole, Gender.FEMALE);
        UserDTO user10 = new UserDTO("Penny","Hofstader","bigbang@testemail.com","3514786925",true,"46376586980",employeeRole, Gender.FEMALE);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
        userService.save(user9);
        userService.save(user10);

        ProjectDTO project1 = new ProjectDTO("Ticketing Project","PR002",user2, LocalDate.now(),LocalDate.now().plusMonths(2),"This is testng project", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Best Practices","PR007",user3, LocalDate.now().minusMonths(1),LocalDate.now().plusMonths(1),"Cucumber Project", Status.COMPLETED);
        ProjectDTO project3 = new ProjectDTO("Example Project","PR005",user1, LocalDate.now().minusWeeks(3),LocalDate.now().plusWeeks(5),"SDET to BackEnd Engineer", Status.IN_PROGRESS);
        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
    }
}
