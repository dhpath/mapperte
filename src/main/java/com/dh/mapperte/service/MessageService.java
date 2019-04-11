package com.dh.mapperte.service;

import com.alibaba.fastjson.JSON;
import com.dh.mapperte.enpity.*;
import com.dh.mapperte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private IndicatorService indicatorService;
    @Autowired
    private ScoresectionSerevice scoresectionSerevice;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ConfigService configService;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ScoresectionRepository scoresectionRepository;
    @Autowired
    private IndicatorRepositroy indicatorRepositroy;
    private static String[] NUMBER = {"一","二","三","四","五","六","七","八","九","十"};
    public int addMessage(String messageStr, String scoresStr) {
        // step.1 保存主记录
        Message message = JSON.parseObject(messageStr,Message.class);
        Message saveMessage = messageRepository.save(message);
        // step.2 保存成绩
        int mid = saveMessage.getId();
        scoreService.addScores(scoresStr,mid);
        // step.3 保存题目
        List<Topic> topicList = topicService.addTopic(messageStr, mid);
        // 分析参数
        indicatorService.addIndicator(scoresStr,mid,message,topicList);
        // 分析成绩分布段
        scoresectionSerevice.addScoresection(scoresStr,mid,message,topicList);
        // 读取配置文件 放回信息
        configService.getFenxi(mid);
        return mid;
    }

    public String updateMmessageAnalyzes(int mid,String problem,String measure) {
        String analyzes = "";
        Message message = messageRepository.findById(mid).get();
        List<Topic> topicList = topicRepository.findAllByMidOrderByTitleindexAsc(mid);
        List<Scoresection> scoresectionList = scoresectionRepository.findAllByMidOrderById(mid);
        List<Indicator> indicatorList = indicatorRepositroy.findAllByMidOrderByTindex(mid);
        // 第一段的内容
        analyzes+="\n\t一、考试基本情况\n\t"+"本次考试的科目是<<"+message.getSubject()+"》，考试班级是"+message.getCollege()+message.getClassname()+",";
        analyzes += "班级人数为"+message.getClassnum()+"人,"+"实考人数为"+message.getRealnum()+"人,缺（缓）考人数为"+message.getLessnum()+"人。";
        analyzes += "试卷来源于"+message.getSource()+"，共有"+NUMBER[topicList.size()-1]+"大题，满分为"+message.getSumfen()+"分，";
         String str = message.getRealnum()- scoresectionList.get(0).getPass()+"";
        int peploe =Integer.parseInt(str.substring(0,str.indexOf(".")));
        if(peploe==0){
            analyzes += "没有人不及格";
        }else{
            analyzes += "有"+peploe+"不及格";
        }
        analyzes+="，及格率为"+scoresectionList.get(1).getPass()/100+"%。";
        analyzes+="考试方式为"+message.getTestmethod()+"考试，阅卷采用"+message.getMarkingmethod()+"阅卷方式。\n\t";
        // 第二段内容
        analyzes+="二、试卷基本情况\n\t";
        analyzes+="在整个试卷的"+NUMBER[topicList.size()-1]+"个大题中";
        for (int i = 0; i < topicList.size(); i++) {
            analyzes+=",第"+NUMBER[topicList.get(i).getTitleindex()-1]+"大题为"+topicList.get(i).getQuestions()+"题(分值"+topicList.get(i).getScore()+"分)，";
            Indicator indicator = indicatorList.get(i);
            analyzes+="本题得分最高"+indicator.getMax()+"分，最低"+indicator.getMin()+"分，平均"+indicator.getAverage()+"分，难度"+indicator.getDifficulty()+"，区分度"+indicator.getDiscrimination()+"。";
        }
        // 获取全卷信息
        Indicator indicator = indicatorList.get(topicList.size());
        analyzes+="\n\t全卷得分最高"+indicator.getMax()+"分，最低"+indicator.getMin()+"分，平均"+indicator.getAverage()+"分，难度"+indicator.getDifficulty()+"，区分度"+indicator.getDiscrimination()+"。";
        if(indicator.getDifficulty().contains("中等难")||indicator.getDifficulty().contains("较难")&&!indicator.getDiscrimination().contains("较差")){
            analyzes+="\n\t从全卷的各项分析指标综合来看，整个试卷有着较高的质量，结合各大题的分析指标对题目进行适当改进后会更好";

        }else{
            analyzes+="\n\t从全卷的各项分析指标综合来看，整个试卷有着较差的质量，结合各大题的分析指标对题目进行改进后会更好。";
        }
        analyzes+="\n\t三、存在的问题";
        analyzes+="\n\t"+problem;
        analyzes+="\n\t四、改进措施及教学建议";
        analyzes+="\n\t"+measure;
        message.setAnalyzes(analyzes);
        messageRepository.save(message);
        return analyzes;
    }
}
