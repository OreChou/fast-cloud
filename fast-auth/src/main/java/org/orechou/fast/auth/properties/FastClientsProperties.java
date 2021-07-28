package org.orechou.fast.auth.properties;

import lombok.Data;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Data
public class FastClientsProperties {

    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";

}
