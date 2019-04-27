package com.dh.mapperte.controller;

import com.alibaba.fastjson.JSON;
import com.dh.mapperte.enpity.Indicator;
import com.dh.mapperte.enpity.Scoresection;
import com.dh.mapperte.repository.IndicatorRepositroy;
import com.dh.mapperte.repository.MessageRepository;
import com.dh.mapperte.repository.ScoresectionRepository;
import com.dh.mapperte.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageControl {
    @Autowired
    private MessageService messageService;
    @Autowired
    private IndicatorRepositroy indicatorRepositroy;
    @Autowired
    private ScoresectionRepository scoresectionRepository;
    @Autowired
    private MessageRepository messageRepository;
    @RequestMapping("message.add")
    public int addMessage(String message,String scores){
        return messageService.addMessage(message,scores);
    }
    @RequestMapping("fenxi.get")
    public String getFenxi(String mid){
        int midId = Integer.parseInt(mid);
        List<Indicator> allByMidOrderByTindex = indicatorRepositroy.findAllByMidOrderByTindex(midId);
        List<Scoresection> allByMid = scoresectionRepository.findAllByMidOrderById(midId);
        Map<String,Object> map = new HashMap<>();
        map.put("indicators",allByMidOrderByTindex);
        map.put("scoresections",allByMid);
        return JSON.toJSONString(map);
    }
    @RequestMapping("message.analyzes.update")
    public String updateMmessageAnalyzes(String mid,String problem,String measure){
        return messageService.updateMmessageAnalyzes(Integer.parseInt(mid),problem,measure);
    }
    @RequestMapping("message.get")
    public String getMessage(int tid){
        return JSON.toJSONString(messageRepository.findAllByTid(tid));
    }
}
