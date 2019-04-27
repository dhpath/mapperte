package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    private int id;
    private String teacher;
    private String subject;
    private int xhours;
    private String source;
    private int classnum;
    private int realnum;
    private int lessnum;
    private String testmethod;
    private String markingmethod;
    private String startyear;
    private String endyear;
    private String semester;
    private Integer tid;
    private Integer state;
    private Double sumfen;
    private String analyzes;
    private String college;
    private String classname;

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
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "xhours")
    public int getXhours() {
        return xhours;
    }

    public void setXhours(int xhours) {
        this.xhours = xhours;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "classnum")
    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    @Basic
    @Column(name = "realnum")
    public int getRealnum() {
        return realnum;
    }

    public void setRealnum(int realnum) {
        this.realnum = realnum;
    }

    @Basic
    @Column(name = "lessnum")
    public int getLessnum() {
        return lessnum;
    }

    public void setLessnum(int lessnum) {
        this.lessnum = lessnum;
    }

    @Basic
    @Column(name = "testmethod")
    public String getTestmethod() {
        return testmethod;
    }

    public void setTestmethod(String testmethod) {
        this.testmethod = testmethod;
    }

    @Basic
    @Column(name = "markingmethod")
    public String getMarkingmethod() {
        return markingmethod;
    }

    public void setMarkingmethod(String markingmethod) {
        this.markingmethod = markingmethod;
    }

    @Basic
    @Column(name = "startyear")
    public String getStartyear() {
        return startyear;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    @Basic
    @Column(name = "endyear")
    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    @Basic
    @Column(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "tid")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tno) {
        this.tid = tno;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "sumfen")
    public Double getSumfen() {
        return sumfen;
    }

    public void setSumfen(Double sumfen) {
        this.sumfen = sumfen;
    }

    @Basic
    @Column(name = "analyzes")
    public String getAnalyzes() {
        return analyzes;
    }

    public void setAnalyzes(String analyzes) {
        this.analyzes = analyzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                xhours == message.xhours &&
                classnum == message.classnum &&
                realnum == message.realnum &&
                lessnum == message.lessnum &&
                Objects.equals(teacher, message.teacher) &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(source, message.source) &&
                Objects.equals(testmethod, message.testmethod) &&
                Objects.equals(markingmethod, message.markingmethod) &&
                Objects.equals(startyear, message.startyear) &&
                Objects.equals(endyear, message.endyear) &&
                Objects.equals(semester, message.semester) &&
                Objects.equals(tid, message.tid) &&
                Objects.equals(state, message.state) &&
                Objects.equals(sumfen, message.sumfen) &&
                Objects.equals(analyzes, message.analyzes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacher, subject, xhours, source, classnum, realnum, lessnum, testmethod, markingmethod, startyear, endyear, semester, tid, state, sumfen, analyzes);
    }

    @Basic
    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Basic
    @Column(name = "classname")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
