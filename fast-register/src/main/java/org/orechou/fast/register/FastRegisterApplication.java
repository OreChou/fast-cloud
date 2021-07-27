package org.orechou.fast.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableEurekaServer
@SpringBootApplication
public class FastRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastRegisterApplication.class, args);
    }

}
