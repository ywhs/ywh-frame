package com.ywh.cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * CreateTime: 2019-06-16 19:48
 * ClassName: CloudEurekaApplication
 * Package: com.ywh.core.service.impl
 * Describe:
 * springboot启动类
 *
 * @author YWH
 */
@SpringBootApplication(scanBasePackages = "com.ywh")
@EnableEurekaServer
public class CloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }

}
