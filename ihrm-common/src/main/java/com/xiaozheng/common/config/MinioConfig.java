package com.xiaozheng.common.config;

import com.xiaozheng.common.utils.MinioUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * @Author: zrs
 * @Date: 2020/12/01/17:05
 * @Description: 创建Bean
 */
@Configuration
@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix ="minio.config")
public class MinioConfig {
 
  // @Value("${minio.endpoint}")
  private String endpoint;
  // @Value("${minio.bucketName}")
  private String bucketName;
  // @Value("${minio.accessKey}")
  private String accessKey;
  // @Value("${minio.secretKey}")
  private String secretKey;
 
  @Bean
  public MinioUtils creatMinioClient() {
    return new MinioUtils(endpoint, bucketName, accessKey, secretKey);
  }
 
}