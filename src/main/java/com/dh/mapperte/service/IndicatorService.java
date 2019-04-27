package com.dh.mapperte.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.dh.mapperte.enpity.*;
import com.dh.mapperte.repository.ConfigRepositroy;
import com.dh.mapperte.repository.IndicatorRepositroy;
import com.dh.mapperte.repository.ScoreRepository;
import com.dh.mapperte.utils.ParameterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class IndicatorService {
    @Autowired
    private IndicatorRepositroy indicatorRepositroy;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ConfigRepositroy configRepositroy;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addIndicator(String scoresStr, int mid, Message message, List<Topic> topicList) {
        List<Score> scores = JSON.parseArray(scoresStr,Score.class);
        int index = 1;
        for (int i = 0; i < topicList.size(); i++) {
            List<Double> scorelist = new ArrayList<>();
            // 获取每题学生的分数
            for (int j = 0; j < scores.size(); j++) {
                List<Map<String,Double>> scoremaplist =JSON.parseObject(scores.get(j).getScroelist(),new TypeReference< List<Map<String,Double>>>(){}) ;
                scorelist.add(scoremaplist.get(i).get("greade"));
            }
            indeixattorJS(mid, topicList.get(i).getScore(), index, scorelist);
            index++;
        }
        List<Double> scorelist = new ArrayList<>();
        List<Score> allByMid = scoreRepository.findAllByMid(mid);
        for (int i = 0; i < allByMid.size(); i++) {
            scorelist.add(allByMid.get(i).getSum());
        }
        indeixattorJS(mid,new Double(message.getSumfen()).intValue(), index, scorelist);
    }

    public void indeixattorJS(int mid, int score, int index, List<Double> scorelist) {
        Config config = configRepositroy.findById(1).get();
        Indicator indicator = new Indicator();
        indicator.setMid(mid);
        indicator.setTindex(index);
        // 分数值
        indicator.setStandardscore(score*0.1*10);
        // 计算最高分
        double max = ParameterUtils.calculateMax(scorelist);
        indicator.setMax(max);
        // 计算最低分
        double min = ParameterUtils.calculateMin(scorelist);
        indicator.setMin(min);
        // ranges 全距
        double ranges = max - min;
        indicator.setRanges(ranges);
        //  平均分
        double averge = ParameterUtils.calculateAverage(scorelist);
        indicator.setAverage(averge);
        // 中位数
        double median = ParameterUtils.calculateMedian(scorelist);
        indicator.setMedian(median);
        // 标准差
        double std = ParameterUtils.calculateStd(scorelist,averge);
        indicator.setStd(std);
        // 难度
        double difficulty = ParameterUtils.calculateDifficulty(averge,score);
        String diff = "";
        String difficultyconfig = config.getDifficultyconfig();
        JSONObject jsonObject = JSON.parseObject(difficultyconfig);
        List<Double> difficultylist=JSON.parseObject(JSON.toJSONString(jsonObject.get("list")),new TypeReference<List<Double>>(){});
        List<String> difficultval=JSON.parseObject(JSON.toJSONString(jsonObject.get("val")),new TypeReference<List<String>>(){});
        for (int i = 0; i < difficultylist.size(); i++) {
            if (difficulty<difficultylist.get(i)){
                diff ="" + difficulty + difficultval.get(i);
                break;
            }
        }
        indicator.setDifficulty(diff);
        // 区分度
        double discrimination = ParameterUtils.calculateDiscrimination(scorelist,score);
        String discrimina = "";
        String discriminationconfig = config.getDiscriminationconfig();
        JSONObject discriminationObject = JSON.parseObject(discriminationconfig);
        List<Double> discriminationlist=JSON.parseObject(JSON.toJSONString(discriminationObject.get("list")),new TypeReference<List<Double>>(){});
        List<String> discriminationval=JSON.parseObject(JSON.toJSONString(discriminationObject.get("val")),new TypeReference<List<String>>(){});
        for (int i = 0; i < discriminationlist.size(); i++) {
            if (discrimination<discriminationlist.get(i)){
                discrimina ="" + discrimination + discriminationval.get(i);
                break;
            }
        }
        indicator.setDiscrimination(discrimina);
        indicatorRepositroy.save(indicator);
    }

    public static void main(String[] args) {
        System.out.println(0.5<3.0);
    }
}
