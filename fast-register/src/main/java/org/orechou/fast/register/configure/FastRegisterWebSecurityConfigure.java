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
        // 禁用对 /eureka/** 的 CSRF 防护
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
