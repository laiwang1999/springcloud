package com.yang.springcloud.controller;

import com.yang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    // 理解：消费者，不应该有service层
    // RestTemplate    供我们直接调用就可以了，注册到Spring中
    /*
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables)
     */
    @Autowired
    private RestTemplate restTemplate; //提供多种远程便携访问http服务的方法,简单的restful服务模板
    //    通过Ribbon实现的时候，我们这个地址应该是一个变量,通过服务名来访问
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    //http://localhost:8001/dept/get
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept getDept(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/get")
    public List<Dept> getAllDept() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get", List.class);
    }
}
