package com.melo.starter;

import com.melo.thriftteam.invoke.SimpleInvoker;
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
public class ThriftApplication {

    private static ThriftServer thriftServer;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftApplication.class, args);
        try {
            SimpleInvoker simpleInvoker = new SimpleInvoker();
            simpleInvoker.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
