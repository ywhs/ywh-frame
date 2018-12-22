package com.ywh.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ywh")
/**
 * 全局配置，扫描指定包下的dao接口，不用每个dao接口上都写@Mapper注解了
 */
@MapperScan(basePackages = "com.ywh.core.dao")
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}

