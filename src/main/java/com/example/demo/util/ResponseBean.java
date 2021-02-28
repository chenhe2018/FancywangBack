package com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseBean implements Serializable {
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    ResponseBean(){

    }
    public static ResponseBean build(){
        return new ResponseBean();
    }
    public String ok(Object data){
        this.data = data;
        this.code = "200";
        this.msg = "success";
        return this.toJson();
    }
    public String error(){
        this.code = "500";
        this.msg = "fail";
        return this.toJson();
    }
    private String toJson(){
        try {
//            return new ObjectMapper().writeValueAsString(this);
            return new Gson().toJson(this);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("uid","uid");
        stringStringHashMap.put("growth","0");
        stringStringHashMap.put("justcheck","0");
        ResponseBean build = ResponseBean.build();
        System.out.println(ResponseBean.build().ok(stringStringHashMap));
    }
}
