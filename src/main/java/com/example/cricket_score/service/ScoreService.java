package com.example.cricket_score.service;

import com.example.cricket_score.model.Score;
import com.example.cricket_score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public int updateScore(Score score) {
        int row = scoreRepository.value();
        if (row == 0) {
            score.setTotalRuns(score.getRuns());
            scoreRepository.save(score);
            int total = scoreRepository.findByTotalRuns(1);
            return total;
        } else {
            int total = scoreRepository.findByTotalRuns(1);
            int totalBowl = scoreRepository.findByTotalBowl(1);
            int runs = score.getRuns();
            int value = total + runs;
            score.setTotalRuns(value);

            scoreRepository.updateValue(score.getTotalRuns());
            return total;
        }

    }

    public int getRun() {
       int total =  scoreRepository.findByTotalRuns(1);
       return total;
    }
}
