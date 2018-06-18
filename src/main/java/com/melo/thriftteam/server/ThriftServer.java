package com.melo.thriftteam.server;

import com.melo.thriftteam.invoke.SimpleInvoker;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * springboot启动时调用该方法启动服务
     */
    public void init() {
        SimpleInvoker simpleInvoker = new SimpleInvoker();
        try {
            simpleInvoker.startServer();
            LOGGER.info("start thrift server success");
        } catch (TTransportException e) {
            LOGGER.error("start thrift server fail", e);
        }
    }

}
