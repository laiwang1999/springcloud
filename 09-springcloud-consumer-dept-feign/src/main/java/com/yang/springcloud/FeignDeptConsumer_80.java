package com.yang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//Ribbon和Eureka整合之后，客户端可以直接调用方法，不用关心IP地址和端口号
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.yang.springcloud"})
//在微服务启动的时候就能去加载自定义的Ribbon类
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
