package com.ywh.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.ywh.common.base.Constants;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.ywh")
/**
 * 全局配置，扫描指定包下的dao接口，不用每个dao接口上都写@Mapper注解了
 */
@MapperScan(basePackages = "com.ywh.**.dao")
public class CoreApplication {

	private static final Logger log = LoggerFactory.getLogger(CoreApplication.class);

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
		SpringApplication.run(CoreApplication.class, args);
	}


	/**
	 * 时间处理
	 */
	@Bean(name = "mapperObject")
	public ObjectMapper getObjectMapper() {
		log.debug("jackson日期时间处理");
		ObjectMapper om = new ObjectMapper();
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		// serializer
		javaTimeModule.addSerializer(Date.class, new DateSerializer(false, new SimpleDateFormat(Constants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Constants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ofPattern(Constants.DEFAULT_DATE_FORMAT)));
		javaTimeModule.addSerializer(LocalTime.class,new LocalTimeSerializer(DateTimeFormatter.ofPattern(Constants.DEFAULT_TIME_FORMAT)));
		om.registerModule(javaTimeModule);

		return om;
	}
}

