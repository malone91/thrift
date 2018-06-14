package com.melo.thriftalone.server;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 76009
 * @date 2018/6/6
 */
public class ServerMain {

    public static void main(String[] args) {
        ThriftServiceProcessor processor = new ThriftServiceProcessor(
                new ThriftCodecManager(),
                new ArrayList<ThriftEventHandler>(),
                new HelloServiceImpl()
        );
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ThriftServerDef serverDef = ThriftServerDef.newBuilder()
                .listen(8899)
                .withProcessor(processor)
                .using(executorService)
                .build();
        ExecutorService bossExecutor = Executors.newFixedThreadPool(1);
        ExecutorService workerExecutor = Executors.newFixedThreadPool(1);
        NettyServerConfig serverConfig = NettyServerConfig.newBuilder()
                .setBossThreadExecutor(bossExecutor)
                .setWorkerThreadExecutor(workerExecutor)
                .build();
        ThriftServer server = new ThriftServer(serverConfig, serverDef);
        server.start();
    }
}
