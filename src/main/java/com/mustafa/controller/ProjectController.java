package com.mustafa.controller;


import com.mustafa.dto.ProjectDTO;
import com.mustafa.dto.UserDTO;
import com.mustafa.enums.Status;
import com.mustafa.services.ProjectService;
import com.mustafa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findManagers());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        projectService.save(project);
        project.setStatus(Status.OPEN);


        return "redirect:/project/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id,Model model){
        projectService.deleteById(id);
        return "redirect:/project/create";
    }


}
