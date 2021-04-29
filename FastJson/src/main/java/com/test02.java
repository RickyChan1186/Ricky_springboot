package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ricky
 * @create 2020-03-19 9:28
 */
public class test02 {


    public static void main(String[] args) {

        //模板文件地址
        String inputUrl = "d:\\test.docx";
        //新生产的模板文件
        String outputUrl = "d:\\aa.docx";

        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("name", "小明");
        testMap.put("sex", "男");
        testMap.put("address", "软件园");
        testMap.put("phone", "88888888");

        List<String[]> testList = new ArrayList<String[]>();
        testList.add(new String[]{"1","1AA","1BB","1CC"});
        testList.add(new String[]{"2","2AA","2BB","2CC"});
        testList.add(new String[]{"3","3AA","3BB","3CC"});
        testList.add(new String[]{"4","4AA","4BB","4CC"});

        WorderToNewWordUtils.changWord(inputUrl, outputUrl, testMap, testList);
    }







}
