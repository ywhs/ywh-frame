package com.ywh.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * CreateTime: 2018-12-18 20:39
 * ClassName: MybatisPlusConfig
 * Package: com.ywh.common.config
 * Describe:
 * MybatisPlus的配置类
 *
 * @author YWH
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
