package com.melo.thriftteam.service;

import org.apache.thrift.TException;

/**
 * 服务实现类
 * Created by 76009 on 2018/6/14.
 */
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String sayHello(User user) throws TException {
        return "hello," + user.getName() + ":" + user.getEmail();
    }
}
