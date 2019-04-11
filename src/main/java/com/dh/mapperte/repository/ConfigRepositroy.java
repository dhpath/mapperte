package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ConfigRepositroy  extends JpaRepository<Config,Integer> {
    public List<Config> findAllByTid(int tid);
}
