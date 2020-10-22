package com.eurekaclient01.demo;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import brave.sampler.Sampler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class DemoApplication {

    public static void main(String[] args)
    {
        int port = 0;
        int defaultPort = 8001;
        //Future表示一个可能还没有完成的异步任务的结果              //多线程调用
        //同步可以先执行下面
        Future<Integer> future = ThreadUtil.execAsync(() ->{
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
            //获取输入端口
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String strPort = scanner.nextLine();
                //对输入判断
                if(!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                    continue;
                }
                else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });
        try{
            port=future.get(5,TimeUnit.SECONDS);  //timeUnit.seconds 秒 获取future的返回值
        }
        catch (InterruptedException | ExecutionException | TimeoutException e){
            port = defaultPort;
        }

        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(DemoApplication.class).properties("server.port=" + port).run(args);
    }

    @Bean
    public Sampler mySimpler(){
        return Sampler.ALWAYS_SAMPLE; //抽样就是去看这个时间点有多少微服务被调用了
    }

    }


