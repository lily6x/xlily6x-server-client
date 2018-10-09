package com.xlily6x.client.register;

/**
 * @program: xlily6x-server-client
 * @description: 服务注册配置
 * @author: xiaowenlong
 * @create: 2018-09-28
 **/
public class RegisterConfig {
    //注册服务器主机
    private String serverHost = "127.0.0.1";
    //注册服务器端口号
    private String serverPort = "61378";
    //本地心跳服务端口
    private String port = "60333";
    //注册服务类型
    private String serviceType = "service";
    //本地服务提供方端口
    private String servicePort = "8080";
    //心跳启动延迟时间 单位 毫秒
    private long taskDelay = 1000*1*30;
    //心跳间隔时间 单位 毫秒
    private long taskPeriod = 1000*1*30;

    public RegisterConfig() {
    }

    public RegisterConfig(String port,String serverHost, String serverPort, String serviceType, String servicePort, long taskDelay, long taskPeriod) {
        this.port = port.equals("")?this.port:port;
        this.serverHost = serverHost.equals("")?this.serverHost:serverHost;
        this.serverPort = serverPort.equals("")?this.serverPort:serverPort;
        this.serviceType = serviceType.equals("")?this.serviceType:serviceType;
        this.servicePort = servicePort.equals("")?this.servicePort:servicePort;
        this.taskDelay = taskDelay<=0?this.taskDelay:taskDelay;
        this.taskPeriod = taskPeriod<=0?this.taskPeriod:taskPeriod;
    }

    @Override
    public String toString() {
        return "RegisterConfig{" +
                "serverHost='" + serverHost + '\'' +
                ", serverPort='" + serverPort + '\'' +
                ", port='" + port + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", servicePort='" + servicePort + '\'' +
                ", taskDelay=" + taskDelay +
                ", taskPeriod=" + taskPeriod +
                '}';
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port.equals("")?this.port:port;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost.equals("")?this.serverHost:serverHost;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort.equals("")?this.serverPort:serverPort;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType.equals("")?this.serviceType:serviceType;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort.equals("")?this.servicePort:servicePort;
    }

    public long getTaskDelay() {
        return taskDelay;
    }

    public void setTaskDelay(long taskDelay) {
        this.taskDelay = taskDelay<=0?this.taskDelay:taskDelay;
    }

    public long getTaskPeriod() {
        return taskPeriod;
    }

    public void setTaskPeriod(long taskPeriod) {
        this.taskPeriod = taskPeriod<=0?this.taskPeriod:taskPeriod;
    }
}
