package com.example.cricket_score.service;

import com.example.cricket_score.model.Bowler;
import com.example.cricket_score.repository.BowlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BowlerService {
//    @Autowired
//    private BowlerModelRepository bowlerModelRepository;


    @Autowired
    private BowlerRepository bowlerRepository;

    public int updateScore(Bowler bowler) {
        int row = bowlerRepository.value();
        if (row == 0) {
            bowler.setBowl(bowler.getBowl());
            bowlerRepository.save(bowler);
            int total = bowlerRepository.findByTotalBowl(1);
            return total;
        } else {
            int total = bowlerRepository.findByTotalBowl(1);
            int runs = bowler.getRun();
//            int value = total + runs;
//            bowler.setTotalRuns(value);

//            bowlerRepository.updateValue(bowler.getTotalRuns());
            return total;
        }

    }
//
//    public int getRun() {
//       int total =  bowlerRepository.findByTotalRuns(1);
//       return total;
//    }



}
