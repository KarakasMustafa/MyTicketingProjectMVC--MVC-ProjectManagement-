package com.mustafa.controller;

import com.mustafa.dto.UserDTO;
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
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());


        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user,Model model){

        userService.save(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id){

        userService.deleteById(id);
        return "redirect:/user/create";

    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id,UserDTO user,Model model){

        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable("id") String id,Model model){
        model.addAttribute("user",userService.findById(id));
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "/user/update";
    }
}
