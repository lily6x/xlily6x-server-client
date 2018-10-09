服务提供者-客户端
初始化版本 1.0.0-SNAPSHOT

1. 集成服务注册
    将本客户端打成Jar文件， 在服务提供者引入该文件。并初始化服务
    ServiceRegister.init(RegisterConfig r);


2. 本地代理服务注册
    将本客户端打成Jar文件，通过java -jar 命令运行jar文件。

    * 命令行运行 主程序
     * @param: [args]
     * 支持参数：
     *      --server.host 注册中心主机
     *      --server.port 注册中心端口号
     *      --service.port 本地心跳服务端口号
     *      --service.type 服务提供者类型
     *      --port 服务提供者端口号
     *      --task.delay 心跳启动延迟时间 单位 毫秒
     *      --task.period 心跳间隔时间 单位 毫秒
     *
     *      eg ： java -jar XX.jar --server.host=127.0.0.1 --server.port=61378