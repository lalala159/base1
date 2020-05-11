package com.hc.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hc.common.dao")
@ComponentScan(basePackages = {"com.hc.common.*","com.hc.system.*"})
@EnableCaching
@EnableScheduling
public class SystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}