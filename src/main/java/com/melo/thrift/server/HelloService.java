package com.melo.thrift.server;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 *
 * @author 76009
 * @date 2018/6/6
 */
@ThriftService("helloService")
public interface HelloService {

    /**
     *
     * @param User
     * @return
     */
    @ThriftMethod
    public String sayHello(@ThriftField(name = "user") User user);
}
