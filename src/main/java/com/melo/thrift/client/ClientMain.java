package com.melo.thrift.client;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.melo.thrift.server.HelloService;
import com.melo.thrift.server.User;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author 76009
 * @date 2018/6/6
 */
public class ClientMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThriftClientManager clientManager = new ThriftClientManager();
        FramedClientConnector clientConnector = new FramedClientConnector(new InetSocketAddress("localhost", 8899));

        User user = new User();
        user.setName("melo");
        user.setEmail("test@qq.com");

        HelloService helloService = clientManager.createClient(clientConnector, HelloService.class).get();
        String contetn = helloService.sayHello(user);
        System.out.println(contetn);
    }
}
