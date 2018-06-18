package com.melo.starter;

import com.melo.thriftteam.server.ThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 该注解指定项目为springboot，由此类当作程序入口自动装配 web 依赖的环境
 * Created by Ablert
 * on 2018/6/15.
 * @author Ablert
 */
@SpringBootApplication
public class SpringbootApplication {

    private static ThriftServer thriftServer;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
        thriftServer = applicationContext.getBean(ThriftServer.class);
        if (thriftServer != null) {
            thriftServer.init();
        }
    }
}
