package com.melo.thriftteam.test;

import com.melo.thriftteam.invoke.SimpleInvoker;
import org.apache.thrift.TException;

import java.util.concurrent.TimeUnit;

/**
 * 该类主要用于
 * @author 76009
 * @date 2018/6/14
 */
public class BlockingServer {

    public static void main(String[] args) throws TException {
        SimpleInvoker simpleInvoker = new SimpleInvoker();
        simpleInvoker.startServer();
    }
}
