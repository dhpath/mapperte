package com.dh.mapperte.repository;

import com.dh.mapperte.enpity.Teacher;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    List<Teacher> findByTnoEqualsAndPwdEquals(String tno,String pwd);
    List<Teacher> findByTelEqualsAndPwdEquals(String tel,String pwd);
}
