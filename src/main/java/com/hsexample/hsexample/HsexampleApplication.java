package com.hsexample.hsexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hsexample.hsexample.mapper") //扫描的mapper
@SpringBootApplication
public class HsexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsexampleApplication.class, args);
    }

}
