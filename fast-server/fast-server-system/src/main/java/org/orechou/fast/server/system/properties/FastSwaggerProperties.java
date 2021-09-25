package org.orechou.fast.server.system.properties;

import lombok.Data;

/**
 * @author OreChou
 * @date 2021/09/24
 */
@Data
public class FastSwaggerProperties {

    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;

    private String grantUrl;
    private String name;
    private String scope;

}
