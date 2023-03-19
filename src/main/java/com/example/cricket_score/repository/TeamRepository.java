package com.example.cricket_score.repository;

import com.example.cricket_score.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Modifying
    @Transactional
    @Query(value = "update team set role = :role, innings = :innings where id = :id", nativeQuery = true)
    int updateValue(@Param("role") String role, @Param("innings") String innings, @Param("id") long id);
}
