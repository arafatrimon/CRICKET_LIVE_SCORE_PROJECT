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



    public void initRuns(){
        int row = scoreRepository.value();
        if(row==0){
          int val =  scoreRepository.initializeTotalRun();
        }
    }

    public int updateScore(Score score) {


        int row = scoreRepository.value();
        Bowler bowler = new Bowler();
        long scoreId= scoreRepository.findScoreId();

        if (row == 0) {

            score.setTotalRuns(score.getRuns());
            score.setBowl(score.getBowl());
            bowler.setBowl(score.getBowl());
            bowler.setName("Rimon");
            scoreRepository.save(score);
            bowlerRepository.save(bowler);



            int total = (int) scoreRepository.findByTotalRuns(scoreId);
            return total;
        } else {
            int total = (int) scoreRepository.findByTotalRuns(scoreId);
            int bowl = scoreRepository.findByTotalBowl(scoreId);
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
        long scoreId= scoreRepository.findScoreId();
        int total = (int) scoreRepository.findByTotalRuns(scoreId);
        return total;
    }

    public Double getOver() {
        long scoreId= scoreRepository.findScoreId();
        int bowl = scoreRepository.findByTotalBowl(scoreId);
        int value = Math.round(bowl / 6);
        int mod = bowl % 6;
        double total = Double.valueOf(value + "." + mod);
        return total;
    }
}
