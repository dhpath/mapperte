package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByTid(int tid);
}
