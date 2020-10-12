package com.yang.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {  //@Configuration就相当于spring applicationContext.xml
    //配置负载均衡实现RestTemplate
    //IRule
    /*
    AvailabilityFilteringRule:会先过滤掉跳闸，访问故障的服务，对剩下的轮询
    RoundRobinRule：轮询
    RandomRule：随机
    RetryRule：会先按照轮询获取服务，如果获取失败，则会在指定的时间内进行重试
     */
    @Bean
    @LoadBalanced  //Ribbon
    public RestTemplate getRestTemplate() {
//        IRule
        return new RestTemplate();
    }
}
