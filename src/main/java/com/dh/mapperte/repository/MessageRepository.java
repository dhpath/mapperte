package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageRepository extends JpaRepository<Message,Integer> {
}
