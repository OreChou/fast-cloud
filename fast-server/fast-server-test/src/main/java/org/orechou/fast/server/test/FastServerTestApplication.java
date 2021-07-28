package org.orechou.fast.server.test;

import org.orechou.fast.common.annotation.FastCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@FastCloudApplication
public class FastServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastServerTestApplication.class, args);
    }

}
