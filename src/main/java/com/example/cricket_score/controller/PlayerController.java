package com.example.cricket_score.controller;

import com.example.cricket_score.model.Player;
import com.example.cricket_score.model.Team;
import com.example.cricket_score.service.PlayerService;
import com.example.cricket_score.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
   private PlayerService playerService;
    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public String team(){
        return "player";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Player player){
         playerService.save(player);
         return "redirect:";
    }

    @ModelAttribute("teamList")
    public List<Team> getAllTeam(){
        List<Team> teams=teamService.getAllTeams();
        return teams;
    }



}
