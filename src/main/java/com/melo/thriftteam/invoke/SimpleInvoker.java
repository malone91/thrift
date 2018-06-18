package com.melo.thriftteam.invoke;

import com.melo.thriftteam.service.HelloService;
import com.melo.thriftteam.service.HelloServiceImpl;
import com.melo.thriftteam.service.User;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by 76009 on 2018/6/14.
 */
public class SimpleInvoker {

    /**
     * 简单的启动服务启动服务
     * @throws TTransportException
     */
    public void startServer() throws TTransportException {
        //创建processor
        TProcessor tProcessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        //服务端口
        int port = 8091;
        //创建transport阻塞通信
        TServerSocket serverSocket = new TServerSocket(port);
        //创建protocol
        TBinaryProtocol.Factory protocol = new TBinaryProtocol.Factory();
        //将processor transport protocol设置到服务器server中
        TServer.Args args = new TServer.Args(serverSocket);
        args.processor(tProcessor);
        args.protocolFactory(protocol);
        //定义服务器类型设定参数
        TServer server = new TSimpleServer(args);
        //开启服务
        server.serve();
    }

    /**
     * 启动客户端
     * @throws TException
     */
    public void startClient() throws TException {
        String ip = "127.0.0.1";
        int port = 6666;
        int timeOut = 1000;
        //创建transport
        TTransport transport = new TSocket(ip, port, timeOut);
        //创建TProtocol
        TProtocol protocol = new TBinaryProtocol(transport);
        //基于transport 和 protocol创建client
        HelloService.Client client = new HelloService.Client(protocol);
        transport.open();

        //调用client方法
        User user = new User();
        user.setName("melo");
        user.setEmail("test@qq.com");
        String content = client.sayHello(user);
        System.out.println("content: " + content);
    }
}
