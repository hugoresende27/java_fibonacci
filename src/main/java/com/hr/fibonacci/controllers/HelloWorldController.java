package com.hr.fibonacci.controllers;

import com.hr.fibonacci.backend.Fibonacci;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(Model view){
        view.addAttribute("message", "Hello World");
        view.addAttribute("message2", "Boss");
        view.addAttribute("fibotest", Fibonacci.printFibo2(0,100));
        return "helloworld";
    }

    @GetMapping("/style")
    public String style(){
        return "add-css-js-demo";
    }

    @GetMapping("/bootstrap")
    public String bootstrap(){
        return "bootstrap";
    }
}
