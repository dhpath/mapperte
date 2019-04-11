package com.dh.mapperte.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.dh.mapperte.enpity.Score;
import com.dh.mapperte.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addScores(String scoresStr, int mid) {
        List<Score> scores = JSON.parseArray(scoresStr,Score.class);
        for (Score score : scores) {
            score.setMid(mid);
            score.setSum(summation(score.getScroelist()));
            scoreRepository.save(score);
        }
        scoreRepository.saveAll(scores);
    }
    public double summation(String gradeStr){
        List<Map<String,String>> grades = JSON.parseObject(gradeStr,new TypeReference<List<Map<String,String>>>(){});
        double sum = 0;
        for (Map<String, String> grade : grades) {
            String grade1 = grade.get("greade").trim();
            if(!"".equals(grade1) ){
                sum += Double.parseDouble(grade1);
            }
        }
        return sum;
    }
}
