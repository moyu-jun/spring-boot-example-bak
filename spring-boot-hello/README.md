# Spring Boot 入门教程详解

Spring Boot 如今已经成为 Java 后端开发的主流技术框架，它以优雅，简洁，快捷开发等特性成为了 Java 后端开发的不二之选。

[Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 开源项目分享了很多 Spring Boot 相关的技术实践，本系列中的项目会尽量贴近生产，贴近企业开发。而不仅仅是提供一些简单的 Demo。同时在项目中可能会踩到的坑也会一一说明。

本篇作为 [Spring Boot Example](https://github.com/JemGeek/spring-boot-example) 系列的第一篇，主要介绍本系列的架构，以及 Spring Boot 的一些基本知识。

## Spring Boot Example 项目概述

工具、组件版本：

| 环境                 | 版本          |
| :-------------------- | :------------- |
| IDEA                 | 2019.3        |
| JDK                  | 1.8           |
| Maven                | 3.x           |
| Spring Boot          | 2.2.5.RELEASE |
| Spring Cloud         | Hoxton.SR3    |
| Spring Cloud Alibaba | 2.2.1.RELEASE |

> 以上 Spring 三套件的依赖版本参考于 [Spring Cloud Alibaba 版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

Spring Boot Example 项目结构：

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

>  注：本篇介绍的项目开发为独立项目，旨在介绍独立项目的创建与基础开发，故 Spring Boot 版本为 `2.3.0.RELEASE` 最新版本。后续的文章将使用聚合型项目结构，版本按照 `Spring Boot Example` 的项目版本说明。

### Spring Boot 项目创建

在 IDEA 编辑器左上角依次选择 `File -> New -> Project...` 创建一个新的项目，在弹出界面中选择 `Spring Initializr` ，其他使用默认选项即可。

![1.png](https://i.loli.net/2020/05/26/s7dfpiyYruNzgw6.png)

1. 选择 `Spring Initializr` ，创建一个 Spring Boot 项目；
2. `Project SDK` 为 JDK 的版本选择，如没有，可点击右侧的 `New` 按钮添加本地的 JDK 环境；
3. 选择默认的 Spring Boot 初始化地址即可；
4. 点击 `Next` 下一步。

![2.png](https://i.loli.net/2020/05/26/cfDShobBMq3LxGT.png)

1. 输入你的 `Group` （一般为域名反转+业务线）及 `Artifact` （一般为项目名称+模块）；
2. 项目版本，按照自己的习惯来，或者参考《阿里巴巴 Java 开发手册》；
3. 包名，即源代码中的代码包根目录。一般为域名反转+业务线+模块。

![3.png](https://i.loli.net/2020/05/26/5G8IqKevP1oJg7N.png)

1. 选择你初始需要依赖的组件类型；
2. 选择相应的依赖组件；
3. 已选择的依赖组件信息。

![4.png](https://i.loli.net/2020/05/26/ehYCx4vNQpSA2aL.png)

1. 项目文件名称，最好和前面的保持一致，不一致也可以，但不建议；
2. 项目存储位置，最好将 Java 项目存储在指定位置；
3. 更多设置，一般默认就好。

![5.png](https://i.loli.net/2020/05/26/PtmZocdwhCKLIiE.png)

上图为一个 Spring Boot 项目的文件目录结构，其各部分作用如下：

1. 文件名、项目名、项目存储位置。（如果文件名和项目名不同，在这里会不太一样，可以自己试一下）；
2. 项目的源代码目录 `src` ，包含 Java 代码，配置代码，资源文件，测试代码等；
3. `pom.xml` 文件是项目中所有的组件依赖文件，也就是 maven 依赖文件；
4. `External Libraries` 所以依赖的第三方组件都会被下载到这里。可以在这里查看源码。

至此，一个 Spring Boot 项目就创建完成了。

### Maven 依赖

`Maven` 是 `Apache 软件基金会` 所提供的一个 `软件（尤其是 Java 软件）项目管理和自动构建工具` 。Maven 使用项目对象模型（Project Object Model，POM）来配置。项目对象模型存储在名为 pom.xml 的文件中。

Spring Boot 项目创建完毕之后，会自动生成一个初始的 `pom.xml` 文件。我们只需要在里面进行相应的配置即可。`pom.xml` 文件的基础配置如下所示，相应部分的作用已做注释。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- 模型版本，固定 4.0.0 -->
    <modelVersion>4.0.0</modelVersion>
    <!-- 指定父级依赖为 Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <!-- 项目坐标，唯一标识此项目 -->
    <groupId>com.xingtuai</groupId>
    <artifactId>spring-boot-hello</artifactId>
    <version>1.0.0</version>

    <!-- 项目名及项目描述 -->
    <name>spring-boot-hello</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <!-- 第三方库的依赖，日常使用最多的地方在此 -->
    <dependencies>
        <!-- Spring Boot 项目基础依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <!-- lombok 工具 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!-- Spring Boot 测试组件 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <!-- 作用域，声明此包仅用于编译测试阶段 -->
            <scope>test</scope>
            <!-- 去除重复依赖包 -->
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <!-- 插件设置 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

在 IDEA 编辑器右侧边栏有一个 Maven 图标，点开可以打开 Maven 的管理面板，如下图所示。

![6.png](https://i.loli.net/2020/06/05/sLf1UAq7JQpTEZG.png)

管理面板最上层一排按钮为操作功能按钮，最常用的第一个同步按钮或依赖导入按钮。作用是在 `pom.xml`文件有修改的时候，需要点击一下进行依赖的导入或同步。虽然可以设置为自动导入，但不建议。

下面的 `Lifecycle` 目录为 Maven 生命周期，包含了 clean(清理)、compile(编译)、package(打包)、install(安装)、deploy(部署)等等。其中最常用的是 clean(清理)、package(打包)、install(安装)三个。

### 项目配置文件

Spring Boot 项目默认使用 `application.properties` 为配置文件。使用方式如下所示。

```properties
# 声明运行端口
server.port=8082
# 应用名称
spring.application.name=spring-boot-hello
# 运行环境：dev
#spring.profiles.active=dev
```

除此之外，更常用的可能是 `yaml` 格式的配置文件。`application.yml`  配置文件格式如下所示。

```yaml
# 声明运行端口
server:
  port: 8081
# 应用名称
spring:
  application:
    name: spring-boot-hello
# 运行环境：dev
#  profiles:
#    active: dev
```

可以清晰地看出两种格式的差别。一个是一行一条配置，一个是以层级进行配置。这种以层级进行配置的方式看起来会更方便更清晰。所以我们更喜欢使用 `yaml` 格式作为配置文件。而且仔细观察你可以发现  `application.properties` 文件默认编码格式为 `GBK` 而不是 `UTF-8`。

**综上所述，推荐使用 `yaml` 格式作为配置文件。**

> 引申问题：如果同时存在两种配置文件，会加载哪一个？

如果同时存在 `application.properties` 和 `application.yml` 文件的话，最终加载的配置会是 `application.properties` 中的配置信息。

### 接口开发

由于篇幅问题，在此不会介绍项目分层的问题，仅做一个简单的接口提供访问，具体的项目分层及更详细的知识将在下一篇文章中详细介绍。

创建一个测试接口在 Spring Boot 中是非常简单的工作。在我看来 Spring Boot 最大的特点就是 **约定大于配置** ，大大简化了我们的开发，让开发者更专注于业务而不是各种繁琐的配置。

首先创建一个 `controller` 的包用来存放 Controller 相关的类。然后创建一个 `HelloController` 做为测试接口类入口。代码如下：

```java
package com.xingtuai.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/6/5
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
```

主要介绍一下几个注解的作用。

1. `@RestController` 注解需要放在类上，它等价于 `@Controller` + `@ResponseBody` 。表示这是一个 RESTful 接口，返回对象信息而不是返回一个页面。
2. `@RequestMapping("test")` 标记这个类的接口映射，对应 `http://domain:port/test/xxx` 路径下的接口。
3. `@GetMapping("/hello")` 标记方法的请求映射，并标记这是个 Get 请求，对应 `http://domain:port/test/hello` 接口。

这样，一个简单地 Get 请求的接口就完成了。只要访问 `http://localhost:8080/test/hello` 接口即可返回字符：`Hello Spring Boot!`

### 项目运行

Spring Boot 项目创建完成之后，会根据项目名称生成一个启动类，如本项目生成了一个 `SpringBootHelloApplication` 启动类。源码如下：

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author James
 */
@SpringBootApplication
public class SpringBootHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }
}
```

这个启动类可以自己创建，可以修改名称，主要满足两个条件即可。

1. 使用注解 `@SpringBootApplication` 来标记这是一个 Spring Boot 应用。
2. 需要创建 `public static void main(String[] args)` 方法，并在方法中加入 `SpringApplication.run(SpringBootHelloApplication.class, args);` 语句。


![7.png](https://i.loli.net/2020/06/05/GEeLNmBZRfby17Q.png)

运行项目只需要按照上图所示，使用工具栏的按钮，选择启动类，点击启动即可。或者在启动类中鼠标右键选择 `Run 'SpringBootHelloApplication'`。

在启动完成之后会在控制台输出以下日志。

![8.png](https://i.loli.net/2020/06/05/MbHdjeGL4BWJtvx.png)

日志中可以看到项目启动的一些信息，如端口号（8082），使用的容器（Tomcat 9.0.35），启动花费的时间（2.122 seconds）等等。

运行成功之后，访问我们创建的接口 `http://localhost:8082/test/hello` 可以看到如下结果。

![11.png](https://i.loli.net/2020/06/05/or1ny9Zzq8T4AeE.png)

传统的 Java 后端项目可能需要你去配置 Tomcat ，然后将后端项目打包成 `war`包，然后部署运行。但是  Spring Boot 却默认集成 Tomcat ，不需要配置，会自动默认打包成 `jar` 包，运行时使用命令 `java -jar spring-boot-hello-1.0.0.jar` 即可。比传统的方式更加的方便、快捷，当然如果你想要打包成 `war` 包，仅需要做一些些小小的配置即可。

### 项目部署

因为 Spring Boot 项目打包时默认为 `jar` 包，所以我们在部署的时候只需要将 `jar` 包上传到服务器上，然后使用命令 `java -jar spring-boot-hello-1.0.0.jar` 运行即可。当然需要配合一些其他命令使用，比如后台运行`nohup java -jar spring-boot-hello-1.0.0.jar &` 等。

打包步骤如下：

1. 打开右侧 `maven ` 面板，然后点击 `Lifecycle` - `clean` 清理项目，再点击 `Lifecycle` - `package` 打包即可。

![9.png](https://i.loli.net/2020/06/05/rhAE6mvNOZgpoj7.png)

2. 打包完成之后，会在项目中创建一个 `target` 文件夹，文件夹下会有一个以 `项目名-版本.jar` 的 `jar` 包存在。这个`jar` 包就是最终可执行的文件。

![10.png](https://i.loli.net/2020/06/05/BvUNhPFcCrkWI8A.png)

当然，除了使用命令 `java -jar xxx.jar` 这种简单的部署方式外，还有很多部署方式。比如使用 Docker 部署，比如使用 Nginx 代理等等。这些内容将会在后续的文章中做详细的介绍。