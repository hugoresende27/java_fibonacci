package com.hr.fibonacci.controllers;

import com.hr.fibonacci.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/iteration")
    public String bootstrap(Model view){
        List <User> users = new ArrayList<>();
        users.add(new User(1,"hugo","resende","hresende","hugo@hugo"));
        users.add(new User(2,"as","ass","axs","hugo@xas"));
        users.add(new User(3,"SAs","dd","xasx","axs@hugo"));
        users.add(new User(4,"dadsad","ads","xxas","axs@xasxa"));
        users.add(new User(5,"hugDDASo","xzx","dasd","xa@xasxa"));
        view.addAttribute("users",users);
        return "bootstrap";
    }
}
