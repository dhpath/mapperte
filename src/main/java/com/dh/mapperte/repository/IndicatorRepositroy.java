package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IndicatorRepositroy extends JpaRepository<Indicator,Integer> {
    List<Indicator> findAllByMidOrderByTindex(int mid);
}
