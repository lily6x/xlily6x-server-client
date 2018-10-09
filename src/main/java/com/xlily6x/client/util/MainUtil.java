package com.xlily6x.client.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: xlily6x-server-client
 * @description: 主程序工具类  
 * @author: xiaowenlong
 * @create: 2018-09-28
 **/
public class MainUtil {

    private static Log logger = LogFactory.getLog(MainUtil.class);

    //可选参数名
    public final static String P1 = "port";
    public final static String P2 = "server.host";
    public final static String P3 = "server.port";
    public final static String P4 = "service.type";
    public final static String P5 = "service.port";
    public final static String P6 = "task.delay";
    public final static String P7 = "task.period";

    //main 方法 可选参数列表
    private static String [] parmNames = new String[]{P1,P2,P3,P4,P5,P6,P7};


    /**
     * 动态解析可选参数
     * @param: [args]
     * @return: void
     * @author: xiaowenlong
     * @date: 2018/9/28
     */ 
    public static Map<String,String> resolveArgs(String [] args){
        Map<String,String> parms = getParms();
        for(String as : args){
            //解析参数 key value
            String key = as.trim().substring(2,as.indexOf("="));
            String value = as.trim().substring(as.indexOf("=")+1,as.length());
            logger.info("param "+key+":"+value);
            if(parms.containsKey(key)){
                //添加 值到 map 中
                parms.put(key,value);
            }
        }
        return parms;
    }

    /**
     * 将可选参数名称数组转为集合
     * @param: []
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @author: xiaowenlong
     * @date: 2018/9/28
     */ 
    private static Map<String,String> getParms(){
        Map<String,String> pms = new HashMap<String, String>();
        for(String p : parmNames){
            pms.put(p,"");
        }
        return pms;
    }
}
