package com.example.cricket_score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller@RequestMapping("/toss-details")
public class TossController {

    @GetMapping("/")
    public String tossDetails() {
        return "toss_details";
    }
}
