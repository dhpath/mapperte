package com.dh.mapperte.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dh.mapperte.enpity.Config;
import com.dh.mapperte.repository.ConfigRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ConfigConteol {
    @Autowired
    private ConfigRepositroy configRepositroy;
    @RequestMapping("config.tid.get")
    public Object getConfigTid(int tid){
        List<Config> allByMid = configRepositroy.findAllByTid(tid);
        if(allByMid.size()==0){
            Optional<Config> byId = configRepositroy.findById(1);
            return byId.get();
        }
        return allByMid.get(0);
    }
    @RequestMapping("config.add")
    public boolean addConfig(int tid,String configs){
        List<Config> allByMid1 = configRepositroy.findAllByTid(tid);
        if(allByMid1.size()==0){
            Config config = new Config();
            JSONObject jsonObject = JSON.parseObject(configs);
            config.setMeasure(jsonObject.get("measure").toString());
            config.setProblem(jsonObject.get("problem").toString());
            configRepositroy.save(config);
        }else{
            Config config = allByMid1.get(0);
            JSONObject jsonObject = JSON.parseObject(configs);
            config.setMeasure(jsonObject.get("measure").toString());
            config.setProblem(jsonObject.get("problem").toString());
            configRepositroy.save(config);
        }
        return true;
    }
}
