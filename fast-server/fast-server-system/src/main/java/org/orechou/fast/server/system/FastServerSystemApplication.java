package org.orechou.fast.server.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author OreChou
 * @date 2021/07/27
 * EnableGlobalMethodSecurity 开启 Spring Cloud Security 权限注解
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FastServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastServerSystemApplication.class, args);
    }

}
