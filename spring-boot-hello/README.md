# Spring Boot Hello

Spring Boot 如今已经成为 Java 后端开发的主流技术框架，它以优雅，简洁，快捷开发等特性成为了 Java 后端开发的不二之选。

[Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 开源项目分享了很多 Spring Boot 相关的技术实践，本系列中的项目会尽量贴近生产，贴近企业开发。而不仅仅是提供一些简单的 Demo。同时在项目中可能会踩到的坑也会一一说明。

本篇作为 [Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 系列的第一篇，主要介绍本系列的架构，以及 Spring Boot 的一些基本知识。

## 项目依赖

工具、组件版本：

| 环境                 | 版本          |
| :-------------------- | :------------- |
| IDEA                 | 2019.3        |
| JDK                  | 1.8           |
| Maven                | 3.x           |
| Spring Boot          | 2.2.5.RELEASE |
| Spring Cloud         | Hoxton.SR3    |
| Spring Cloud Alibaba | 2.2.0.RELEASE |

项目结构：

```
spring-boot-example
├── spring-boot-hello -- Spring Boot 基础
├── spring-boot-dependencies -- 项目统一依赖
├── spring-boot-mybatis -- Spring Boot Mybatis 系列
|    ├── spring-boot-mybatis-xml -- Mybatis XML 模式实现
|    └── spring-boot-mybatis-plugin -- Mybatis 使用插件实现
└── spring-boot-log4j2 -- 详解 Spring Boot 中默认日志框架 Slf4j 与 log4j2 使用
```

所有的项目用到的组件的版本统一使用 `spring-boot-dependencies` 模块进行管理，以便于统一版本，及后续维护时的版本升级。





















