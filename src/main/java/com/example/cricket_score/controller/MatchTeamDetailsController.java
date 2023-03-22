package com.example.cricket_score.controller;

import com.example.cricket_score.model.MatchTeamDetails;
import com.example.cricket_score.model.Player;
import com.example.cricket_score.model.Team;
import com.example.cricket_score.service.MatchTeamDetailsService;
import com.example.cricket_score.service.PlayerService;
import com.example.cricket_score.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/match-team-details")
public class MatchTeamDetailsController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @Autowired
    private MatchTeamDetailsService matchTeamDetailsService;

    @GetMapping("/")
    public String matchTeamDetails() {
        return "match_team_details";
    }

    @ModelAttribute("teamList")
    public List<Team> getAllTeam() {
        return teamService.getAllTeams();
    }

    @GetMapping("/player-by-team/{id}")
    public ModelAndView getPlayerByTeam(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        List<Player> players = playerService.findPlayerByTeam(id);
        redirectAttributes.addFlashAttribute("player", players);
        model.addAttribute("player", players);
//        return players;
        //  redirectAttributes.addFlashAttribute("playerList,",players);
        return new ModelAndView("match-team-details");
    }

    @GetMapping("/valueGet/{id}")
    ResponseEntity<?> getValue(@PathVariable Long id) {
        List<Player> players = playerService.findPlayerByTeam(id);
        return ResponseEntity.ok(players);
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MatchTeamDetails matchTeamDetails) {
        matchTeamDetailsService.save(matchTeamDetails);
        return "redirect:";
    }

    @GetMapping("/matchValue/{id}")
    ResponseEntity<?> getValueById(@PathVariable Long id) {
        Object [][] team = matchTeamDetailsService.getValueById(id);
        return ResponseEntity.ok().body(team);
    }

}
