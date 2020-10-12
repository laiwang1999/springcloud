# Spring Cloud

四个核心问题：

1. 服务很多，客户端怎么访问
2. 服务很多，服务之间如何通信
3. 如何治理
4. 服务挂了怎么办

解决方案，Spring Cloud    生态！用来解决上面的问题

1. Spring Cloud NetFlix	一站式解决方案
   - Api网关，zuul组件
2. Apache Dubbo Zookeeper   半自动，需要整合别人的
3. Spring Cloud Alibaba     一站式解决方案

# 微服务技术栈

# ![image-20201011091519667](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201011091519667.png)Spring Cloud 入门概述

## Spring Boot与Spring Cloud的关系

- Spring Boot用来快速方便的开发单个个体微服务   -jar
- Spring Cloud 是一个关注全局的微服务协调框架，将Spring Boot开发的单体服务整合起来，为各个微服务之间提供：配置管理，服务发现，熔断器，路由，微代理，时间总线，全局锁，决策竞选，分布式会话等等集成服务。
- Spring Boot可以离开Spring Cloud单独使用，但是Spring Cloud离不开Spring Boot，属于依赖关系
- Spring Boot关注与开发单个个体微服务，Spring Cloud关注全局的服务治理框架

## Dubbo和Spring Cloud技术选型

### 1.分布式+服务治理Dubbo

目前成熟的的互联网架构：应用服务化拆分+消息中间件

![image-20201011094744559](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201011094744559.png)

**最大区别**：Spring Cloud抛弃了Dubbo的RPC通信，采用的是基于Http的Rest方式

设计模式+微服务拆分思想

![image-20201011095846579](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201011095846579.png)

![image-20201011100022076](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201011100022076.png)

# REST环境搭建

## 建立实体类服务

## 建立Provider

## 建立Consumer

# Eureka

![image-20201011195400645](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201011195400645.png)

# CAP原则

- CAP原则又称CAP定理，指的是在一个分布式系统中，[一致性](https://baike.baidu.com/item/一致性/9840083)（Consistency）、[可用性](https://baike.baidu.com/item/可用性/109628)（Availability）、[分区容错性](https://baike.baidu.com/item/分区容错性/23734073)（Partition tolerance）。CAP 原则指的是，这三个要素最多只能同时实现两点，不可能三者兼顾。

![image-20201012082843337](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201012082843337.png)

![image-20201012083108689](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201012083227712.png)

![image-20201012083247003](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201012083247003.png)

# Ribbon

![image-20201012083933518](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201012083933518.png)

LB(Load Balance):负载均衡

## 自定义负载均衡算法

![image-20201012130517974](https://gitee.com/yang_jian_white/test-picgo/raw/master/image-20201012130517974.png)

# Feign

# Hystrix

对雪崩产生的链路保护机制

注解@HystrixCommand,5s内20次调用失败就会启动熔断机制

Hystrix 供分布式系统使用，提供延迟和容错功能，隔离远程系统、访问和第三方程序库的访问点，防止级联失败，保证复杂的分布系统在面临不可避免的失败时，仍能有其弹性。

能干嘛：

- 服务降级
- 服务熔断
- 服务限流
- 接近实时的监控
- …