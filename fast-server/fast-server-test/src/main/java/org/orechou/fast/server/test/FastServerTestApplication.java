package org.orechou.fast.server.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FastServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastServerTestApplication.class, args);
    }

}
