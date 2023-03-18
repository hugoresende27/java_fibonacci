package com.hr.fibonacci.controllers;

import com.hr.fibonacci.backend.FiboFinal;

import com.hr.fibonacci.models.FiboForm;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FiboController {



    Map<Map<Integer,String>,Map<Integer,Integer>> allHistory = new HashMap<>();
    @GetMapping("/fibo")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm());
        return mv;
    }


    @GetMapping("/fibo-index")
    public ModelAndView makeFibonacciSequencesByIndex(@ModelAttribute FiboForm fiboForm) throws IllegalAccessException {
        long timeStart = System.currentTimeMillis();
        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        Map<Integer,String> historyRec = new HashMap<>();
        historyRec.put( allHistory.size() + 1 , "index" );
        allHistory.put(historyRec,makeHistory(start,end));

        String fiboSeqIndex = FiboFinal.printFiboIndexes(start,end);
        long timePerformance = System.currentTimeMillis() - timeStart;
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm(start,end));
        mv.addObject("fiboSeqIndex", fiboSeqIndex);
        mv.addObject("allHistory", allHistory);
        mv.addObject("time", timePerformance);
        return mv;

    }
    @GetMapping("/fibo-limit")
    public ModelAndView makeFibonacciSequencesByLimits(@ModelAttribute FiboForm fiboForm){
        long timeStart = System.currentTimeMillis();
        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());
        Map<Integer,String> historyRec = new HashMap<>();
        historyRec.put( allHistory.size() + 1 , "limit" );
        allHistory.put(historyRec,makeHistory(start,end));

        String fiboSeqLimits = FiboFinal.printFiboLimits(start,end);
        long timePerformance = System.currentTimeMillis() - timeStart;
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("fiboForm", new FiboForm(start,end));
        mv.addObject("fiboSeqLimits", fiboSeqLimits);
        mv.addObject("allHistory", allHistory);
        mv.addObject("time", timePerformance);
        return mv;

    }

    private static Map<Integer,Integer> makeHistory(int start, int end){
        Map<Integer,Integer> historyRec = new HashMap<>();
        historyRec.put(start,end);
        return historyRec;
    }
}
