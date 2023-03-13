package com.example.cricket_score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/squad")
    public String squad() {
        return "squad";
    }

    @GetMapping("/point-table")
    public String pointTable() {
        return "point_table";
    }

    @GetMapping("/score")
    public String score() {
        return "score";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/opening-bat-ball")
    public String openingBatBall() {
        return "openingBatBall";
    }

    @ModelAttribute("toss")
    public Map<Integer, String> outType() {
        Map<Integer, String> outType = new HashMap<>();
        outType.put(0, "");
        outType.put(1, "Bat");
        outType.put(2, "Bowl");
        return outType;
    }










}
