package com.example.cong.helloworld.Tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cong on 2017-06-13.
 */

public class StatusTool {

    private static Map<String,String> map=new HashMap<>();

    /**
     * "newly"|          //新建态
     "initing"|        //正在初始化
     "initFail"|       //初始化失败
     "initSuccess"|    //初始化成功
     "ongoing"|        //考试正在进行
     "timeup"|         //考试时间到
     "analyzing"|      //正在分析结果
     "analyzingFinish" //结果分析完毕
     */
    static {
        map.put("newly","正在创建");
        map.put("initing","正在初始化");
        map.put("initFail","初始化失败");
        map.put("initSuccess","初始化成功");
        map.put("ongoing","进行中");
        map.put("timeup","考试时间到");
        map.put("analyzing","分析中");
        map.put("analyzingFinish","分析完成");
    }

    public static String getStatus(String status){
        return map.get(status);
    }

}
