package com.dh.mapperte.enpity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Topic {
    private int id;
    private Integer mid;
    private String questions;
    private int score;
    private int titleindex;

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
    @Column(name = "questions")
    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "titleindex")
    public int getTitleindex() {
        return titleindex;
    }

    public void setTitleindex(int titleindex) {
        this.titleindex = titleindex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id == topic.id &&
                score == topic.score &&
                titleindex == topic.titleindex &&
                Objects.equals(mid, topic.mid) &&
                Objects.equals(questions, topic.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, questions, score, titleindex);
    }
}
