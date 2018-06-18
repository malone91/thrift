package com.melo.starter;

import com.melo.thriftteam.service.HelloService;
import com.melo.thriftteam.service.HelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * springboot启动时启动该类的服务
 * Created by Ablert
 * on 2018/6/15.
 * @author Ablert
 */
@Component
public class ThriftServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftServer.class);

    @Value("${thrift.port}")
    private int port;
    @Value("${thrift.minWorkerThreads}")
    private int minThreads;
    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    @Autowired
    private HelloServiceImpl helloService;

    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    /**
     * 启动
     */
    public void start() {
        HelloService.Processor processor = new HelloService.Processor<HelloService.Iface>( helloService );
        init();
        try {
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            LOGGER.info("thrift服务启动成功, 端口={}", port);
            server.serve();
        } catch (Exception e) {
            LOGGER.error("thrift服务启动失败", e);
        }
    }

}
