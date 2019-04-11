package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
