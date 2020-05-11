# Spring Boot系列之Log4j2的配置使用

[参考文档 1 ](https://www.jianshu.com/p/46b530446d20)
[参考文档 2 ](https://www.cnblogs.com/darknebula/p/10009212.html)

后台程序开发及上线时，一般都会用到Log信息打印及Log日志记录，开发时通过 Log 信息可以快速的定位问题所在，帮助我们快捷开发。程序上线后如遇到 Bug 或错误，此时则需要日志记录来快速查找问题。

Spring Boot 可以集成很多不同的日志系统，如 `logback`、`log4j`、 `log4j2`, `log4j2` 是 `log4j` 的升级版本，`log4j2` 相对于 `log4j 1.x` 有了很多显著的改善。

本篇博客就先来说说 Spring Boot 如何集成并配置使用 `log4j2`。

## 1. 导入 Log4j2 的包

在 `pom.xml` 中，加入以下依赖，版本号统一在 `spring-boot-dependencies` 中的 `pom.xml` 管理。

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <!-- Spring Boot 默认支持 logback -->
                <!-- 所以需要排除 logback -->
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- log4j2 依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        <!-- disruptor 提供了异步记录日志的功能 -->
        <dependency>
            <groupId>com.lmax</groupId>
            <artifactId>disruptor</artifactId>
            <!-- 项目中，版本号统一在 spring-boot-dependencies 中的 pom.xml 管理 -->
            <!--<version>3.3.6</version>-->
        </dependency>
        <!-- others -->
        <!-- 引入 lombok 可以使用它提供的标准 @Slf4j 注解 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
```

## 2. 添加 log4j2 配置文件

在项目的resources资源文件根目录下创建 `log4j2.xml` 文件并复制以下代码到文件中。文件说加了很多注释说明，

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- Configuration后面的status，这个用于设置 log4j2 自身内部的信息输出，可以不设置，当设置成trace时，
 你会看到log4j2内部各种详细输出。可以设置成OFF(关闭)或 Error (只输出错误信息)
-->
<Configuration status="OFF">
    <!-- 日志文件目录和压缩文件目录配置 -->
    <Properties>
        <Property name="fileName">/logs/spring-boot-log</Property>
        <Property name="fileGz">/logs/spring-boot-log/7z</Property>
    </Properties>

    <Appenders>
        <!-- 输出控制台日志的配置 -->
        <Console name="console" target="SYSTEM_OUT">
            <!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
            <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
            <!-- 输出日志的格式 -->
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36}: %msg%n"/>
        </Console>

        <!-- 打印出所有的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档 -->
        <RollingRandomAccessFile name="infoFile" fileName="${fileName}/web-info.log" immediateFlush="false"
                                 filePattern="${fileGz}/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.web-info.gz">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} %L %M: %msg%xEx%n" />
            <Policies>
                <TimeBasedTriggeringPolicy interval="6" modulate="true" />
                <SizeBasedTriggeringPolicy size="50 MB"/>
            </Policies>
            <Filters>
                <!-- 只记录info和warn级别信息 -->
                <ThresholdFilter level="error" onMatch="DENY" onMismatch="NEUTRAL"/>
                <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY" />
            </Filters>
            <!-- 指定每天的最大压缩包个数，默认7个，超过了会覆盖之前的 -->
            <DefaultRolloverStrategy max="50"/>
        </RollingRandomAccessFile>

        <!-- 存储所有error信息 -->
        <RollingRandomAccessFile name="errorFile" fileName="${fileName}/web-error.log" immediateFlush="false"
                                 filePattern="${fileGz}/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.web-error.gz">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} %L %M: %msg%xEx%n" />
            <Policies>
                <TimeBasedTriggeringPolicy interval="6" modulate="true" />
                <SizeBasedTriggeringPolicy size="50 MB"/>
            </Policies>
            <Filters>
                <!-- 只记录error级别信息 -->
                <ThresholdFilter level="error" onMatch="ACCEPT" onMismatch="DENY" />
            </Filters>
            <!-- 指定每天的最大压缩包个数，默认7个，超过了会覆盖之前的 -->
            <DefaultRolloverStrategy max="50"/>
        </RollingRandomAccessFile>
    </Appenders>

    <!-- 全局配置，默认所有的Logger都继承此配置 -->
    <Loggers>
        <!-- AsyncRoot - 异步记录日志 - 需要LMAX Disruptor的支持 -->
        <AsyncRoot level="info" additivity="false">
            <AppenderRef ref="console"/>
            <AppenderRef ref="infoFile"/>
            <AppenderRef ref="errorFile"/>
        </AsyncRoot>
    </Loggers>
</Configuration>
```

## 3. 配置说明

在上面的 `log4j2.xml` 的配置文件，我们主要关注一下几个点。

1. 日志文件目录和压缩文件目录配置

这个配置申明了日志文件以及压缩日志文件()

```xml
       <!-- 日志文件目录和压缩文件目录配置 -->
       <Properties>
           <Property name="fileName">/logs/spring-boot-log</Property>
           <Property name="fileGz">/logs/spring-boot-log/7z</Property>
       </Properties>
```

## 4. `log4j2` 的使用

配置完成后，我们可以建立一个 `LogController` 来测试一下日志记录。 

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger 日志记录辅助类
 *
 * Created by James on 2017/5/11.
 */
public class L {

    private static final Logger LOGGER = LogManager.getLogger();

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static Logger getLogger(){
        return LOGGER;
    }

    public static void t(String msg) {
        LOGGER.trace(msg);
    }

    public static void d(String msg) {
        LOGGER.debug(msg);
    }

    public static void i(String msg) {
        LOGGER.info(msg);
    }

    public static void w(String msg) {
        LOGGER.warn(msg);
    }

    public static void e(String msg) {
        LOGGER.error(msg);
    }
    public static void f(String msg) {
        LOGGER.fatal(msg);
    }
}
```

编写完辅助类，使用起来就很简单了，通过下面的代码就可以轻松使用。

```java
@Controller
public class WebController {
    @RequestMapping("/")
    public String index(){
        String msg = "Spring Boot系列之Log4j2的配置及使用";
        L.t(msg); // Log4j2.xml中配置的level="info",所以此条信息并不会打印在控制台
        L.d(msg); // 同上，级别：TRACE < DEBUG < INFO < WARN < ERROR < FATAL
        L.i(msg);
        L.w(msg);
        L.e(msg);
        L.f(msg);
        return "index";
    }
}
```

这里的辅助类只是写了一些基本的使用方法，你可以根据你的需求进行定制，增加更多的辅助方法。对于辅助类中没有提供的方法也可以使用`L.getLogger()`方法获取Logger实例来使用。

## 4. 结果验证

日志的Level分级：TRACE < DEBUG < INFO < WARN < ERROR < FATAL。

因为我的log4j2中的level设置的是`INFO`级别。所以打印信息中只能看到 `INFO` 、`WARN` 、 `ERROR` 三种级别(FATAL级别的信息没有打印，否则也可以看到)。

打印信息如下图所示：

![Log Info](https://ooo.0o0.ooo/2017/05/11/59141c76b8b07.png)

同时在电脑系统中生成了Log文件，如下图所示：

![Log File](https://i.loli.net/2019/04/01/5ca223a39fdc0.png)

观察路径可以发现，这个路径正是在`Log4j2.xml`中设置的路径：

```xml
    <!-- 日志文件目录和压缩文件目录配置 -->
    <Properties>
        <Property name="fileName">/home/James/log/spring_log</Property>
        <Property name="fileGz">/home/James/log/spring_log/7z</Property>
    </Properties>
```

## 5. 更多

Log4j2的Github地址：[https://github.com/apache/logging-log4j2](https://github.com/apache/logging-log4j2)

本教程的示例代码地址：[https://github.com/JemGeek/spring-boot-sample/tree/master/spring-boot-log4j2](https://github.com/JemGeek/spring-boot-sample/tree/master/spring-boot-log4j2)

更多技术文章请关注我的博客主页：[http://JemGeek.com](http://JemGeek.com)

或者订阅我的微信公众号【Techno Geek】

![wechat_qrcode.jpg](https://i.loli.net/2019/04/01/5ca2246b9d918.jpg)
