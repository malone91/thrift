package com.melo.thriftalone.server;

import com.facebook.swift.codec.ThriftField;

/**
 *
 * @author 76009
 * @date 2018/6/6
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(@ThriftField(name = "user") User user) {
        return "hello: " + user.getName() + user.getEmail();
    }
}
