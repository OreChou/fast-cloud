package org.orechou.fast.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author OreChou
 * @date 2021/09/24
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:fast-server-system.properties"})
@ConfigurationProperties(prefix = "fast.server.system")
public class FastServerSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private FastSwaggerProperties swagger = new FastSwaggerProperties();

}
