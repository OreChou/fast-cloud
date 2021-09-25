package org.orechou.fast.server.system;

import org.mybatis.spring.annotation.MapperScan;
import org.orechou.fast.common.annotation.FastCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author OreChou
 * @date 2021/07/27
 * EnableGlobalMethodSecurity 开启 Spring Cloud Security 权限注解
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@FastCloudApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("org.orechou.fast.server.system.mapper")
@EnableTransactionManagement
public class FastServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastServerSystemApplication.class, args);
    }

}
