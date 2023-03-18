package com.hr.fibonacci.controllers;

import com.hr.fibonacci.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class TaskController {

    List<Task> tasksList= new ArrayList<>();
    @GetMapping("/task-create")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("task-app/create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/task-create")
    public String create(Task task){



        System.out.println(task);
        //to edit task if already exist
        if (task.getId() != null){
            Task taskFind = tasksList.stream().filter(taskItem -> Objects.equals(task.getId(), taskItem.getId())).findFirst().get();
            tasksList.set(tasksList.indexOf(taskFind), task);

        } else {
            long id = tasksList.size() + 1L; //convert 1 para tipo long
            tasksList.add(new Task(id, task.getName(), task.getDate()));


        }
        return "redirect:/task-list";       //redirect:/url
    }

    /*
    this ModelAndView return type, create an instance of this class of spring,
    addObject(name,value) to pass data
     */
    @GetMapping("/task-list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("task-app/list");
        mv.addObject("tasks", tasksList);
        return mv;
    }

    @GetMapping("/task-edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        //to edit, use same view create with populated data
        ModelAndView mv = new ModelAndView("task-app/create");

        Task taskFind = tasksList.stream().filter(task -> id.equals(task.getId())).findFirst().get();

        mv.addObject("task", taskFind);

        return mv;


    }
}
