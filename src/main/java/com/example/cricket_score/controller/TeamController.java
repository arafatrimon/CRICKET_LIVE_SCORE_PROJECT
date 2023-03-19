package com.example.cricket_score.controller;

import com.example.cricket_score.model.Team;
import com.example.cricket_score.service.MatchTeamDetailsService;
import com.example.cricket_score.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;


    @GetMapping("/")
    public String team() {
        return "team";
    }

//    @PostMapping("/save")
//    public String save(@ModelAttribute Team team) {
//        teamService.save(team);
//        return "redirect:";
//    }

    @PostMapping("/update")
    public String update(@ModelAttribute Team team, Model model, RedirectAttributes redirectAttributes) throws NoSuchFieldException {
        teamService.updateValue(team);
        return "redirect:/";
    }

}
