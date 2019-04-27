package com.dh.mapperte.controller;

import com.dh.mapperte.enpity.Teacher;
import com.dh.mapperte.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherControl {
    @Autowired
    private TeacherRepository teacherRepository;
    @RequestMapping("login.do")
    public Object lognin(String username,String pwd){
        List<Teacher> byTelEqualsAndPwdEquals = teacherRepository.findByTelEqualsAndPwdEquals(username,pwd);
        List<Teacher> byTnoEqualsAndPwdEquals = teacherRepository.findByTnoEqualsAndPwdEquals(username,pwd);
        if(byTelEqualsAndPwdEquals.size()==1){
            Teacher teacher = byTelEqualsAndPwdEquals.get(0);
            teacher.setPwd("");
            return teacher;
        }else if(byTnoEqualsAndPwdEquals.size()==1){
            Teacher teacher = byTnoEqualsAndPwdEquals.get(0);
            teacher.setPwd("");
            return teacher;
        }
        return null;
    }
    @RequestMapping("pwd.do")
    public String pwd(int tid,String usepwd,String newpwd,String newspwd){
        Teacher teacher = teacherRepository.findById(tid).get();
        if(!teacher.getPwd().equals(usepwd)){
            return "原秘密输入错误";
        }
        if(newpwd.trim()==""||newspwd.trim()==""){
            return "新密码不能为空";
        }
        if(!newpwd.trim().equals(newspwd.trim())){
            return "两次密码不一致";
        }
        teacher.setPwd(newpwd);
        teacherRepository.save(teacher);
        return "修改成功" ;
    }
}
