package com.hr.fibonacci.controllers;

import com.hr.fibonacci.backend.FiboFinal;

import com.hr.fibonacci.models.FiboForm;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FiboController {


    @GetMapping("/fibo")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm());
        return mv;
    }

    //original function, calling boot index and limits, deprecated
    @PostMapping("/fibo")
    public ModelAndView makeFibonacciSequences(@ModelAttribute FiboForm fiboForm){

        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        String fiboSeqLimits = FiboFinal.printFiboLimits(start,end);
        String fiboSeqIndex = FiboFinal.printFiboIndexes(start,end);
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm(start,end));
        mv.addObject("fiboSeqLimits", fiboSeqLimits);
        mv.addObject("fiboSeqIndex", fiboSeqIndex);
        return mv;

    }

    @PostMapping("/fibo-index")
    public ModelAndView makeFibonacciSequencesByIndex(@ModelAttribute FiboForm fiboForm){

        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        String fiboSeqIndex = FiboFinal.printFiboIndexes(start,end);
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm(start,end));
        mv.addObject("fiboSeqIndex", fiboSeqIndex);

        return mv;


    }
    @PostMapping("/fibo-limit")
    public ModelAndView makeFibonacciSequencesByLimits(@ModelAttribute FiboForm fiboForm){

        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        String fiboSeqLimits = FiboFinal.printFiboLimits(start,end);
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm(start,end));
        mv.addObject("fiboSeqLimits", fiboSeqLimits);
        return mv;

    }
}
