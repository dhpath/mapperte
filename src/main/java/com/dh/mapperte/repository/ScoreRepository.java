package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ScoreRepository extends JpaRepository<Score,Integer> {
    List<Score> findAllByMid(int mid);
}
