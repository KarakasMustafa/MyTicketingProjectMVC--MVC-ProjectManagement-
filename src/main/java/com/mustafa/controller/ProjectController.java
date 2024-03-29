package com.mustafa.controller;

import com.mustafa.dto.ProjectDTO;
import com.mustafa.dto.TaskDTO;
import com.mustafa.dto.UserDTO;
import com.mustafa.enums.Status;
import com.mustafa.services.ProjectService;
import com.mustafa.services.TaskService;
import com.mustafa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project){

        projectService.save(project);
        project.setProjectStatus(Status.OPEN);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){

        projectService.deleteByID(projectcode);

        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode){

        projectService.complete(projectService.findByID(projectcode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectcode, Model model){

        model.addAttribute("project", projectService.findByID(projectcode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";

    }

    @PostMapping("/update/{projectcode}")
    public String updateProject(@PathVariable("projectcode") String projectcode,ProjectDTO project, Model model){

        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/complete")
    public String getProjectByManager(Model model){

        UserDTO manager = userService.findByID("TestEmail@email.com");
        List<ProjectDTO> projects = getCountedListOfProjectDTO(manager);
        model.addAttribute("projects", projects);

        return "/manager/project-status";
    }

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager){

        List<ProjectDTO> list = projectService.findAll()
                .stream()
                .filter(x -> x.getAssignedManager().equals(manager))
                .map(x -> {
                    List<TaskDTO> taskList = taskService.findTaskByManager(manager);
                    int completeCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() == Status.COMPLETED).count();
                    int incompletedCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() != Status.COMPLETED).count();

                    x.setCompleteCount(completeCount);
                    x.setIncompleteCount(incompletedCount);
                    return x;
                }).collect(Collectors.toList());
        return list;
    }

}
