package com.hr.fibonacci.controllers;

import com.hr.fibonacci.backend.Fibonacci;
import com.hr.fibonacci.models.FiboForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FiboController {

    @GetMapping("/fibo")
    public String index(Model model){
        model.addAttribute("fiboForm", new FiboForm());
        return "fibo";
    }

    @PostMapping("/fibo-send")
    public String sendFibo(@ModelAttribute FiboForm fiboForm, Model model){

        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        String fiboSeq = Fibonacci.printFibo2(start,end);
        System.out.println(fiboSeq);
        System.out.println(start);
        System.out.println(end);
        model.addAttribute("fiboForm", new FiboForm());
        model.addAttribute("fiboSeq", fiboSeq);

        return "fibo";
    }
}
