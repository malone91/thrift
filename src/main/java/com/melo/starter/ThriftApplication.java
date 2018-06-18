package com.melo.starter;

import com.melo.thriftteam.invoke.SimpleInvoker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 该注解指定项目为springboot，由此类当作程序入口自动装配 web 依赖的环境
 * Created by Ablert
 * on 2018/6/15.
 * @author Ablert
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.melo.thriftteam.service", "com.melo.starter"})
public class ThriftApplication {

    private static ThriftServer thriftServer;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftApplication.class, args);
        try {
            thriftServer = context.getBean(ThriftServer.class);
            thriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
