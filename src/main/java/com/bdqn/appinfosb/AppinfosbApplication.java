package com.bdqn.appinfosb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bdqn.appinfosb.dao")
public class AppinfosbApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppinfosbApplication.class, args);
    }

}
