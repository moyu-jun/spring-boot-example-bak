# Spring Boot Hello

Spring Boot 如今已经成为 Java 后端开发的主流技术框架，它以优雅，简洁，快捷开发等特性成为了 Java 后端开发的不二之选。

[Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 开源项目分享了很多 Spring Boot 相关的技术实践，本系列中的项目会尽量贴近生产，贴近企业开发。而不仅仅是提供一些简单的 Demo。同时在项目中可能会踩到的坑也会一一说明。

本篇作为 [Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 系列的第一篇，主要介绍本系列的架构，以及 Spring Boot 的一些基本知识。

## 项目概述

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

`spring-boot-example` 整个项目的基础架构如上所示，所有的项目用到的组件的版本统一使用 `spring-boot-dependencies` 模块进行管理，以便于统一版本，及后续维护时的版本升级。

如果某个知识点内容比较多，比如 `Mybatis` 系列，会开一个模块（`spring-boot-mybatis`）管理 `Mybatis` 相关的子项目。

## Spring Boot 开发

本篇主要详解使用 Spring Boot 开发的一些基础知识与应用。

### Spring Boot 项目创建

在 IDEA 编辑器左上角依次选择 `File -> New -> Project...` 创建一个新的项目，在弹出界面中选择 `Spring Initializr` ，其他使用默认选项即可。

![1.png](https://i.loli.net/2020/05/26/s7dfpiyYruNzgw6.png)

![2.png](https://i.loli.net/2020/05/26/cfDShobBMq3LxGT.png)


![3.png](https://i.loli.net/2020/05/26/5G8IqKevP1oJg7N.png)


![4.png](https://i.loli.net/2020/05/26/ehYCx4vNQpSA2aL.png)


![5.png](https://i.loli.net/2020/05/26/PtmZocdwhCKLIiE.png)





















