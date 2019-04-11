package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Score {
    private int id;
    private String scroelist;
    private double sum;
    private Double standardScore;
    private int mid;

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
    @Column(name = "scroelist")
    public String getScroelist() {
        return scroelist;
    }

    public void setScroelist(String scroelist) {
        this.scroelist = scroelist;
    }

    @Basic
    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "standardScore")
    public Double getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(Double standardScore) {
        this.standardScore = standardScore;
    }

    @Basic
    @Column(name = "mid")
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return id == score.id &&
                Double.compare(score.sum, sum) == 0 &&
                mid == score.mid &&
                Objects.equals(scroelist, score.scroelist) &&
                Objects.equals(standardScore, score.standardScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scroelist, sum, standardScore, mid);
    }
}
