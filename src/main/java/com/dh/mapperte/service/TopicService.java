package com.dh.mapperte.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.dh.mapperte.enpity.Topic;
import com.dh.mapperte.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Topic> addTopic(String messageStr, int mid) {
        JSONObject topicObject = JSON.parseObject(messageStr);
        String bigquestionlist = JSON.toJSONString(topicObject.get("bigquestionlist"));
        List<Topic> topicList = JSON.parseObject(bigquestionlist, new TypeReference<List<Topic>>() {});
        int index = 1;
        for (Topic topic : topicList) {
            topic.setMid(mid);
            topic.setTitleindex(index);
            index++;
        }
        topicRepository.saveAll(topicList);
        return topicList;
    }
}
