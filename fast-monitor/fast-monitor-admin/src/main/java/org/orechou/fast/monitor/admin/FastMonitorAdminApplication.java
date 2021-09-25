package org.orechou.fast.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author OreChou
 * @date 2021/09/25
 */
@EnableAdminServer
@SpringBootApplication
public class FastMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastMonitorAdminApplication.class, args);
    }

}
