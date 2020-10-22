package com.eureka0101.demo;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoApplication {

    public static void main(String[] args) {

        int port = 8761;
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.println("port: "+ port +"被占用");
            System.exit(1);

        }
        new SpringApplicationBuilder(DemoApplication.class).properties("server.port="+port).run(args);

    }

}
