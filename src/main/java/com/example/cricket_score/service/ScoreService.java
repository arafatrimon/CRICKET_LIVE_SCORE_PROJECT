package com.example.cricket_score.service;

import com.example.cricket_score.model.Bowler;
import com.example.cricket_score.model.Score;
import com.example.cricket_score.repository.BowlerRepository;
import com.example.cricket_score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private BowlerRepository bowlerRepository;

    public int updateScore(Score score) {
        int row = scoreRepository.value();
        Bowler bowler = new Bowler();
        if (row == 0) {
            score.setTotalRuns(score.getRuns());
            score.setBowl(score.getBowl());
            bowler.setBowl(score.getBowl());
            bowler.setName("Rimon");
            scoreRepository.save(score);
            bowlerRepository.save(bowler);
            int total = scoreRepository.findByTotalRuns(1);
            return total;
        } else {
            int total = scoreRepository.findByTotalRuns(1);
            int bowl = scoreRepository.findByTotalBowl(1);
            if (bowl == 0) {
                bowl = score.getBowl();
                bowler.setBowl(score.getBowl());
                score.setBowl(bowl);
            } else {
                int totalBowl = bowl + score.getBowl();
                score.setBowl(totalBowl);
                bowler.setBowl(totalBowl);
            }
            int runs = score.getRuns();
            int value = total + runs;
            score.setTotalRuns(value);
            bowler.setRun(value);
            bowler.setName(score.getBowler());
            scoreRepository.updateValue(score.getTotalRuns(), score.getBowl());
//            bowlerRepository.updateValue(score.getTotalRuns(), score.getBowl());
            return total;
        }

    }

    public int getRun() {
        int total = scoreRepository.findByTotalRuns(1);
        return total;
    }

    public Double getOver() {
        int bowl = scoreRepository.findByTotalBowl(1);
        int value = Math.round(bowl / 6);
        int mod = bowl % 6;
        double total = Double.valueOf(value + "." + mod);
        return total;
    }
}
