package com.melo.thriftteam.service;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * 服务实现类
 * 采用springboot的方式
 * @author 76009
 * @date 2018/6/14
 */
@Controller
public class HelloServiceImpl implements HelloService.Iface {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(User user) throws TException {
        LOGGER.info("user:" + user.getName() +":" + user.getEmail());
        return "hello," + user.getName() + ":" + user.getEmail();
    }
}
