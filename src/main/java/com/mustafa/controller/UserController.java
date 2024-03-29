package com.mustafa.controller;

import com.mustafa.bootstrap.DataGenerator;
import com.mustafa.dto.RoleDTO;
import com.mustafa.dto.UserDTO;
import com.mustafa.entity.User;
import com.mustafa.implementations.RoleServiceImpl;
import com.mustafa.services.RoleService;
import com.mustafa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;



    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model){

        userService.save(user);
//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("users", userService.findAll());
//        model.addAttribute("roles", roleService.findAll());
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findByID(username));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());

        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user,Model model){
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteByID(username);
        return "redirect:/user/create";
    }


}
