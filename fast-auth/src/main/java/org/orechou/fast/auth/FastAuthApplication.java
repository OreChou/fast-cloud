package org.orechou.fast.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.orechou.fast.common.annotation.EnableFastAuthExceptionHandler;
import org.orechou.fast.common.annotation.EnableFastLettuceRedis;
import org.orechou.fast.common.annotation.FastCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableDiscoveryClient
@SpringBootApplication
@FastCloudApplication
@EnableFastLettuceRedis
@EnableFastAuthExceptionHandler
@MapperScan("org.orechou.fast.auth.mapper")
public class FastAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastAuthApplication.class, args);
    }

}
