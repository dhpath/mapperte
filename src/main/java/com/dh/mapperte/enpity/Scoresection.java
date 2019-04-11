package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Scoresection {
    private int id;
    private String score4;
    private String score5;
    private String score6;
    private String score7;
    private String score8;
    private String score9;
    private String score10;
    private double pass;
    private double excellent;
    private Integer type;
    private Integer mid;

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
    @Column(name = "score4")
    public String getScore4() {
        return score4;
    }

    public void setScore4(String score4) {
        this.score4 = score4;
    }

    @Basic
    @Column(name = "score5")
    public String getScore5() {
        return score5;
    }

    public void setScore5(String score5) {
        this.score5 = score5;
    }

    @Basic
    @Column(name = "score6")
    public String getScore6() {
        return score6;
    }

    public void setScore6(String score6) {
        this.score6 = score6;
    }

    @Basic
    @Column(name = "score7")
    public String getScore7() {
        return score7;
    }

    public void setScore7(String score7) {
        this.score7 = score7;
    }

    @Basic
    @Column(name = "score8")
    public String getScore8() {
        return score8;
    }

    public void setScore8(String score8) {
        this.score8 = score8;
    }

    @Basic
    @Column(name = "score9")
    public String getScore9() {
        return score9;
    }

    public void setScore9(String score9) {
        this.score9 = score9;
    }

    @Basic
    @Column(name = "score10")
    public String getScore10() {
        return score10;
    }

    public void setScore10(String score10) {
        this.score10 = score10;
    }

    @Basic
    @Column(name = "pass")
    public double getPass() {
        return pass;
    }

    public void setPass(double pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "excellent")
    public double getExcellent() {
        return excellent;
    }

    public void setExcellent(double excellent) {
        this.excellent = excellent;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "mid")
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scoresection that = (Scoresection) o;
        return id == that.id &&
                excellent == that.excellent &&
                Objects.equals(score4, that.score4) &&
                Objects.equals(score5, that.score5) &&
                Objects.equals(score6, that.score6) &&
                Objects.equals(score7, that.score7) &&
                Objects.equals(score8, that.score8) &&
                Objects.equals(score9, that.score9) &&
                Objects.equals(score10, that.score10) &&
                Objects.equals(pass, that.pass) &&
                Objects.equals(type, that.type) &&
                Objects.equals(mid, that.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score4, score5, score6, score7, score8, score9, score10, pass, excellent, type, mid);
    }
}
