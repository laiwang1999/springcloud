package com.yang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yang.springcloud.pojo.Dept;
import com.yang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.List;

//提供restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryDeptById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+",不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    //备选方案
    public Dept hystrix_get(Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+",不存在该用户，为null@Hystrix")
                .setDb_source("no this database in MySql");
    }
}
