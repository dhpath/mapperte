package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Teacher {
    private int id;
    private String tname;
    private String tel;
    private String tno;
    private String pwd;
    private String faculty;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tname")
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "tno")
    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "faculty")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(tname, teacher.tname) &&
                Objects.equals(tel, teacher.tel) &&
                Objects.equals(tno, teacher.tno) &&
                Objects.equals(pwd, teacher.pwd) &&
                Objects.equals(faculty, teacher.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tname, tel, tno, pwd, faculty);
    }
}
