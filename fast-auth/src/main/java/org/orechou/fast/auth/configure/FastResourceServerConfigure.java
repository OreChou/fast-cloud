package org.orechou.fast.auth.configure;

import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.auth.properties.FastAuthProperties;
import org.orechou.fast.common.handler.FastAccessDeniedHandler;
import org.orechou.fast.common.handler.FastAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Configuration
@EnableResourceServer
public class FastResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private FastAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private FastAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private FastAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");

        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
