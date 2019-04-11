package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TopicRepository extends JpaRepository<Topic,Integer> {
    List<Topic> findAllByMidOrderByTitleindexAsc(int mid);
}
