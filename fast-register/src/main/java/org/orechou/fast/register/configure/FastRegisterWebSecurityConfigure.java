package org.orechou.fast.register.configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@EnableWebSecurity
public class FastRegisterWebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用对 /eureka/** 的 CSRF 防护，Spring Boot Admin 通过 /actuator/** 监控接口实现，所以需要将其纳入到免认证路径中
        http.csrf().ignoringAntMatchers("/eureka/**")
                .and()
                .authorizeRequests().antMatchers("/actuator/**").permitAll();
        super.configure(http);
    }

}
