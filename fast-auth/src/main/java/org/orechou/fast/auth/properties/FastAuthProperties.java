package org.orechou.fast.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:fast-auth.properties"})
@ConfigurationProperties(prefix = "fast.auth")
public class FastAuthProperties {

    private FastClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

}
