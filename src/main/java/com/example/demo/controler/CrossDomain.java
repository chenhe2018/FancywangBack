package com.example.demo.controler;

import com.example.demo.util.ResponseBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class CrossDomain {

    private static final Logger log = LoggerFactory.getLogger(CrossDomain.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @RequestMapping(value = "/crossDomainPost",method= RequestMethod.POST)
    public String crossDomainPost(@RequestBody String json){
        //{"url":"http://10.5.23.145:8080/api/upGradeForGrowth","json":"{a:1,b:12}"}
        log.info("====crossDomainPost {}", json);
        try {
            //解析传入的json文本
            Map<String,Object> map = objectMapper.readValue(json, Map.class);
            //获取参数
            String remote_url = (String) map.get("url");
            String remote_json = (String) map.get("json");
            //调用远端的POST接口
            Object object = restTemplate.postForObject(remote_url, remote_json, Object.class);
            //打印远端接口的返回参数
            log.info("====crossDomainPost {}", new Gson().toJson(object));
            //返回文本
            return ResponseBean.build().ok(new Gson().toJson(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseBean.build().error();
    }

}
