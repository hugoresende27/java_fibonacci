package com.hr.fibonacci.controllers;

import com.hr.fibonacci.models.FiboForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

//    @GetMapping("/")
//    String index(Principal principal, Model model){
//        model.addAttribute("fiboForm", new FiboForm());
////        return principal != null ? "fibo/" : "fibo-app/";
//        return "fibo-app/index";
//    }

    @GetMapping("/")
    String index(){
        return "fibo-app/index";
    }
}
