package com.dh.mapperte.service;

import com.dh.mapperte.enpity.Message;
import com.dh.mapperte.enpity.Score;
import com.dh.mapperte.enpity.Scoresection;
import com.dh.mapperte.enpity.Topic;
import com.dh.mapperte.repository.ScoreRepository;
import com.dh.mapperte.repository.ScoresectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoresectionSerevice {
    @Autowired
    private IndicatorService indicatorService;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoresectionRepository scoresectionRepository;
    public void addScoresection(String scoresStr, int mid, Message message, List<Topic> topicList) {
        // 拿到每个学生的总分
        List<Double> scorelist = new ArrayList<>();
        List<Score> allByMid = scoreRepository.findAllByMid(mid);
        for (int i = 0; i < allByMid.size(); i++) {
            scorelist.add(allByMid.get(i).getSum());
        }
        int[] scores = new int[7];
        int jigesum = 0;
        int youxiu = 0;
        for (int i = 0; i < scorelist.size(); i++) {
            if(scorelist.get(i)<40){
                scores[0]++;
            }else if(scorelist.get(i)<50){
                scores[1]++;
            }else if(scorelist.get(i)<60){
                scores[2]++;
            }else if(scorelist.get(i)<70){
                scores[3]++;
            }else if(scorelist.get(i)<80){
                scores[4]++;
            }else if(scorelist.get(i)<90){
                scores[5]++;
            }else if(scorelist.get(i)<100){
                scores[6]++;
            }
            if (scorelist.get(i)>=60){
                jigesum++;
            }
            if(scorelist.get(i)>=80){
                youxiu++;
            }
        }
        // 插入人数
        Scoresection scoresection = new Scoresection();
        scoresection.setScore4(scores[0]+"");
        scoresection.setScore5(scores[1]+"");
        scoresection.setScore6(scores[2]+"");
        scoresection.setScore7(scores[3]+"");
        scoresection.setScore8(scores[4]+"");
        scoresection.setScore9(scores[5]+"");
        scoresection.setScore10(scores[6]+"");
        scoresection.setPass(jigesum);
        scoresection.setExcellent(youxiu);
        scoresection.setType(1);
        scoresection.setMid(mid);
        scoresectionRepository.save(scoresection);
        // 插入百分比
        Scoresection scoresection1 = new Scoresection();
        scoresection1.setScore4(scores[0]*1.0/scorelist.size()+"");
        scoresection1.setScore5(scores[1]*1.0/scorelist.size()+"");
        scoresection1.setScore6(scores[2]*1.0/scorelist.size()+"");
        scoresection1.setScore7(scores[3]*1.0/scorelist.size()+"");
        scoresection1.setScore8(scores[4]*1.0/scorelist.size()+"");
        scoresection1.setScore9(scores[5]*1.0/scorelist.size()+"");
        scoresection1.setScore10(scores[6]*1.0/scorelist.size()+"");
        scoresection1.setPass(new BigDecimal(jigesum*1.0/scorelist.size()).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue());
        scoresection1.setExcellent(new BigDecimal(youxiu*1.0/scorelist.size()).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue());
        scoresection1.setType(2);
        scoresection1.setMid(mid);
        scoresectionRepository.save(scoresection1);
    }
}
