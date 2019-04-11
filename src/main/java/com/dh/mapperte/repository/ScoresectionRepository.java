package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Scoresection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ScoresectionRepository extends JpaRepository<Scoresection,Integer> {
    List<Scoresection> findAllByMidOrderById(int mid);
}
