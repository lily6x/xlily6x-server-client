package com.xlily6x.client;

import com.xlily6x.client.register.RegisterConfig;
import com.xlily6x.client.register.ServiceRegister;
import com.xlily6x.client.util.MainUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * @program: xlily6x-server-client
 * @description: 程序启动类
 * @author: xiaowenlong
 * @create: 2018-09-28
 **/
public class ServerApplication {

    private static Log logger = LogFactory.getLog(ServerApplication.class);

    /**
     * 命令行运行 主程序
     * @param: [args]
     * 支持参数：
     *      --server.host 注册中心主机
     *      --server.port 注册中心端口号
     *      --service.host 服务提供者主机
     *      --service.port 服务提供者端口号
     *      --service.type 服务提供者类型
     *      --port 本地心跳服务端口号
     *      --task.delay 心跳启动延迟时间 单位 毫秒
     *      --task.period 心跳间隔时间 单位 毫秒
     *
     *      eg ： java -jar XX.jar --server.host=127.0.0.1 --server.port=61378
     *
     * @return: void
     * @author: xiaowenlong
     * @date: 2018/9/28
     */
    public final static void main(String [] args){
        logger.info(args);
        Map<String,String> m = MainUtil.resolveArgs(args);
        logger.info(m);
        RegisterConfig r = new RegisterConfig(m.get(MainUtil.P1) ,m.get(MainUtil.P2) ,m.get(MainUtil.P3) ,
                m.get(MainUtil.P4) ,m.get(MainUtil.P5) ,m.get(MainUtil.P6) ,
                m.get(MainUtil.P7).equals("")?0:Long.parseLong(m.get(MainUtil.P7)),
                m.get(MainUtil.P8).equals("")?0:Long.parseLong(m.get(MainUtil.P8)));
        try {
            ServiceRegister.init(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
