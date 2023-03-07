package com.example.cricket_score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ScoreController {

    @GetMapping("/")
    public String home(){
        return "index";
    }


    public Map<Integer,String> outType(){
        Map<Integer,String> outType=new HashMap<>();
        outType.put(1,"Bowled");
        outType.put(2,"Caught");
        outType.put(3,"LBW");
        outType.put(4,"Run out");
        outType.put(5,"Stumped");
        outType.put(6,"Hit wicket");
        outType.put(7,"Retired");
        return  outType;
    }

    public Map<Integer,String> extraRunType(){
        Map<Integer,String> extraRunType=new HashMap<>();
            extraRunType.put(1,"nb");
            extraRunType.put(2,"wd");
            extraRunType.put(3,"lb");
            extraRunType.put(4,"b");
            extraRunType.put(5,"pen");
            return  extraRunType;
    }

    public Map<Integer,Integer> RunType(){
        Map<Integer,Integer> RunType=new HashMap<>();
        RunType.put(1,1);
        RunType.put(2,2);
        RunType.put(3,3);
        RunType.put(4,4);
        RunType.put(5,6);
        return  RunType;
    }

}
