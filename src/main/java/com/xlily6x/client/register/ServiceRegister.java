package com.xlily6x.client.register;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: xlily6x-server-client
 * @description: 服务注册
 * @author: xiaowenlong
 * @create: 2018-09-27
 **/
public class ServiceRegister {

    private static Log logger = LogFactory.getLog(ServiceRegister.class);

    /**
     * 初始化服务注册
     * @param: [registerInfo]
     * @return: void
     * @author: xiaowenlong
     * @date: 2018/9/28
     */ 
    public static void init(final RegisterConfig registerConfig) throws Exception{
        logger.info("Heartbeat service initialization");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    heartbeat(registerConfig);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },registerConfig.getTaskDelay(),registerConfig.getTaskPeriod());
    }

    /**
     * 心跳服务
     * @param registerConfig
     * @throws Exception
     */
    private static void heartbeat(RegisterConfig registerConfig) throws Exception{
        logger.info("Connecting to "+registerConfig.getServerHost()+":"+registerConfig.getServerPort());
        String body = registerConfig.getServiceType()+","+registerConfig.getServiceHost()+","+registerConfig.getServicePort();
        byte [] data = body.getBytes();
        logger.info("Start send heartbeat "+body);
        logger.info(registerConfig);
        DatagramSocket socket = new DatagramSocket(Integer.parseInt(registerConfig.getPort()));

        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName(registerConfig.getServerHost()),Integer.parseInt(registerConfig.getServerPort()));
        socket.send(packet);
        socket.close();

    }


}
