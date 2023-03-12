package com.example.cricket_score.controller;

import com.example.cricket_score.model.Bowler;
import com.example.cricket_score.model.BowlerModel;
import com.example.cricket_score.model.Score;
import com.example.cricket_score.repository.BowlerRepository;
import com.example.cricket_score.service.BowlerService;
import com.example.cricket_score.service.ScoreService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

//    @Autowired
//    private BowlerService bowlerService;

    @GetMapping("/score-update")
    public String updateBallByBall(Model model) {
//        List<?> bowlers=bowlerService.getAllBowler();

        int run = scoreService.getRun();
        double over = scoreService.getOver();

        model.addAttribute("run", run);
        model.addAttribute("over", over);
//        model.addAttribute("bowlers", bowlers);
        return "score_update";
    }

    @ModelAttribute("outTypeList")
    public Map<Integer, String> outType() {
        Map<Integer, String> outType = new HashMap<>();
        outType.put(0, "");
        outType.put(1, "Bowled");
        outType.put(2, "Caught");
        outType.put(3, "Run OUt Striker");
        outType.put(4, "Run Out NonStriker");
        outType.put(5, "LBW");
        outType.put(6, "Stumped");
        outType.put(7, "Hit Wicket");
        outType.put(8, "Retired Hurt Striker");
        outType.put(9, "Retired Hurt NonStriker");
        return outType;
    }

    @ModelAttribute("extraRunTypeList")
    public Map<Integer, String> extraRunType() {
        Map<Integer, String> extraRunType = new HashMap<>();
        extraRunType.put(0, "");
        extraRunType.put(1, "nb");
        extraRunType.put(2, "wd");
        extraRunType.put(3, "lb");
        extraRunType.put(4, "b");
        extraRunType.put(5, "pen");
        return extraRunType;
    }

    @ModelAttribute("runsList")
    public Map<Integer, Integer> Runs() {
        Map<Integer, Integer> Runs = new HashMap<>();
        Runs.put(0, 0);
        Runs.put(1, 1);
        Runs.put(2, 2);
        Runs.put(3, 3);
        Runs.put(4, 4);
        Runs.put(5, 5);
        Runs.put(6, 6);
        Runs.put(7, 7);
        return Runs;
    }

    @ModelAttribute("extraRunList")
    public Map<Integer, String> ExtraRun() {
        Map<Integer, String> ExtraRun = new HashMap<>();
        ExtraRun.put(0, "");
        ExtraRun.put(1, "Wide");
        ExtraRun.put(2, "Wide+bye");
        ExtraRun.put(3, "No Ball");
        ExtraRun.put(4, "No ball+bye");
        ExtraRun.put(5, "bye/legbye");

        return ExtraRun;
    }

    @ModelAttribute("runTypeList")
    public Map<Integer, String> RunType() {
        Map<Integer, String> RunType = new HashMap<>();
        RunType.put(0, "");
        RunType.put(1, "Batted");
        RunType.put(2, "Extra");
        RunType.put(3, "Extra+Batted");
        RunType.put(4, "Out");
        RunType.put(5, "Out+Batted");
        RunType.put(6, "Out+Batted+Extra");
        RunType.put(6, "Out+Extra");
        return RunType;
    }



    @PostMapping("/save")
    public String save(@ModelAttribute Score score, Model model, RedirectAttributes redirectAttributes){
       score.setBowl(1);
        int run=  scoreService.updateScore(score);
       redirectAttributes.addFlashAttribute("run", run);
      return "redirect:/score-update";
    }

//    @ModelAttribute("emailModelAttribute")
//    Score emailModelAttribute() {
//        return score.ge;
//    }
}
