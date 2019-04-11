package com.dh.mapperte.enpity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Config {
    private int id;
    private String difficultyconfig;
    private String discriminationconfig;
    private String problem;
    private String measure;
    private Integer type;
    private Integer tid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "difficultyconfig")
    public String getDifficultyconfig() {
        return difficultyconfig;
    }

    public void setDifficultyconfig(String difficultyconfig) {
        this.difficultyconfig = difficultyconfig;
    }

    @Basic
    @Column(name = "discriminationconfig")
    public String getDiscriminationconfig() {
        return discriminationconfig;
    }

    public void setDiscriminationconfig(String discriminationconfig) {
        this.discriminationconfig = discriminationconfig;
    }

    @Basic
    @Column(name = "problem")
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "measure")
    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
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
    @Column(name = "tid")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer mid) {
        this.tid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return id == config.id &&
                Objects.equals(difficultyconfig, config.difficultyconfig) &&
                Objects.equals(discriminationconfig, config.discriminationconfig) &&
                Objects.equals(problem, config.problem) &&
                Objects.equals(measure, config.measure) &&
                Objects.equals(type, config.type) &&
                Objects.equals(tid, config.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, difficultyconfig, discriminationconfig, problem, measure, type, tid);
    }
}
