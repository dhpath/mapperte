package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Indicator {
    private int id;
    private Integer mid;
    private Double max;
    private Double min;
    private Double ranges;
    private String discrimination;
    private Double average;
    private Double median;
    private Double std;
    private Double standardscore;
    private Integer tindex;
    private String difficulty;

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
    @Column(name = "mid")
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Basic
    @Column(name = "max")
    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Basic
    @Column(name = "min")
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    @Basic
    @Column(name = "ranges")
    public Double getRanges() {
        return ranges;
    }

    public void setRanges(Double ranges) {
        this.ranges = ranges;
    }

    @Basic
    @Column(name = "discrimination")
    public String getDiscrimination() {
        return discrimination;
    }

    public void setDiscrimination(String discrimination) {
        this.discrimination = discrimination;
    }

    @Basic
    @Column(name = "average")
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Basic
    @Column(name = "median")
    public Double getMedian() {
        return median;
    }

    public void setMedian(Double median) {
        this.median = median;
    }

    @Basic
    @Column(name = "std")
    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }

    @Basic
    @Column(name = "standardscore")
    public Double getStandardscore() {
        return standardscore;
    }

    public void setStandardscore(Double standardscore) {
        this.standardscore = standardscore;
    }

    @Basic
    @Column(name = "tindex")
    public Integer getTindex() {
        return tindex;
    }

    public void setTindex(Integer tindex) {
        this.tindex = tindex;
    }

    @Basic
    @Column(name = "difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indicator indicator = (Indicator) o;
        return id == indicator.id &&
                Objects.equals(mid, indicator.mid) &&
                Objects.equals(max, indicator.max) &&
                Objects.equals(min, indicator.min) &&
                Objects.equals(ranges, indicator.ranges) &&
                Objects.equals(discrimination, indicator.discrimination) &&
                Objects.equals(average, indicator.average) &&
                Objects.equals(median, indicator.median) &&
                Objects.equals(std, indicator.std) &&
                Objects.equals(standardscore, indicator.standardscore) &&
                Objects.equals(tindex, indicator.tindex) &&
                Objects.equals(difficulty, indicator.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, max, min, ranges, discrimination, average, median, std, standardscore, tindex, difficulty);
    }
}
