package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2019-09-09 17:02
 */


public class JsonTest {



    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("A-key","A-value");
        jsonObject.put("B-key","B-value");
        jsonObject.put("C-key","C-value");

        JSONArray jsonArray = new JSONArray();
        User user = new User();
        user.setId(1L);
        user.setName("Ricky");
        user.setAddress("12112");
        user.setTime(new Date());

        User user2 = new User();
        user2.setId(1L);
        user2.setName("Ricky");
        user2.setAddress("12112");
        user2.setTime(new Date());

        jsonArray.add(user);
        jsonArray.add(user2);

        jsonObject.put("users",jsonArray);

        System.out.println(jsonObject);

        Map<String,Object> map = new HashMap<String,Object>();
        map = JSON.parseObject(jsonObject.toJSONString(),Map.class);

        for(Map.Entry<String,Object>entry:map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }



    }
}
