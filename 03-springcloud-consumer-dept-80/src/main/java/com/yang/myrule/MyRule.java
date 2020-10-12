package com.yang.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    @Bean
    public IRule myRandomRule(){
        return new MyRandomRule();//默认为轮询，现在换成自己的
    }
}
