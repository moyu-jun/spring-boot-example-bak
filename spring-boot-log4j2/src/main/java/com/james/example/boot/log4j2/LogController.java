package com.james.example.boot.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/5/9
 */
@Slf4j
@RestController
public class LogController {


    @GetMapping("/log")
    public String log(){
        log.info("输出日志: username - {}, method: {}", "James", "log()");
        log.error("输出日志: username - {}, method: {}", "James", "log()");
        return "log";
    }

}
