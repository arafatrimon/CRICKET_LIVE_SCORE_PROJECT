package com.example.cricket_score.repository;

import com.example.cricket_score.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    //@Query(value ="select total_runs from score")
    //    int totalRuns();
    @Query(value = "select count(*) from score", nativeQuery = true)
    int value();

    @Query(value = "select total_runs from score where id = :id", nativeQuery = true)
    int findByTotalRuns(@Param("id") long id);

    @Query(value = "select bowl from score where id = :id", nativeQuery = true)
    int findByTotalBowl(@Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update score set total_runs = :total where id =1",nativeQuery = true)
    void updateValue(@Param("total") int total);

}
