package com.ywh.security.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CreateTime: 2019-01-22 10:27
 * ClassName: JwtTokenUtil
 * Package: com.ywh.security.utils
 * Describe:
 * jwt的工具类
 *
 * @author YWH
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtTokenUtil {

    private String secret;

    private Long expiration;

    private String header;

}
