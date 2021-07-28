package org.orechou.fast.common.configure;

import org.orechou.fast.common.handler.FastAccessDeniedHandler;
import org.orechou.fast.common.handler.FastAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author OreChou
 * @date 2021/07/27
 */
public class FastAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public FastAccessDeniedHandler accessDeniedHandler() {
        return new FastAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public FastAuthExceptionEntryPoint authenticationEntryPoint() {
        return new FastAuthExceptionEntryPoint();
    }

}
