package com.ywh.cloudauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author  杨文辉
 */
@MapperScan(basePackages = "com.ywh.cloudauth.dao.*")
@SpringBootApplication(scanBasePackages = "com.ywh")
public class CloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAuthApplication.class, args);
    }

}
