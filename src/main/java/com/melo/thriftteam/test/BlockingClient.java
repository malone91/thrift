package com.melo.thriftteam.test;

import com.melo.thriftteam.invoke.SimpleInvoker;
import org.apache.thrift.TException;

/**
 * Created by 76009 on 2018/6/14.
 */
public class BlockingClient {

    public static void main(String[] args) throws TException {
        SimpleInvoker simpleInvoker = new SimpleInvoker();
        simpleInvoker.startClient();
    }
}
