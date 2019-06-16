package com.ywh.cloudcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CreateTime: 2019-06-16 19:48
 * ClassName: CloudCoreApplication
 * Package: com.ywh.core.service.impl
 * Describe:
 * springboot启动类
 *
 * @author YWH
 */
@SpringBootApplication(scanBasePackages = "com.ywh")
@MapperScan(basePackages = "com.ywh.**.dao")
public class CloudCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCoreApplication.class, args);
    }

}
