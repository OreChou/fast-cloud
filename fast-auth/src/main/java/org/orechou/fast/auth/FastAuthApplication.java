package org.orechou.fast.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FastAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastAuthApplication.class, args);
    }

}
