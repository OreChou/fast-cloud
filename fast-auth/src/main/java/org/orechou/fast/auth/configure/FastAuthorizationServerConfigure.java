package org.orechou.fast.auth.configure;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.auth.properties.FastAuthProperties;
import org.orechou.fast.auth.properties.FastClientsProperties;
import org.orechou.fast.auth.service.FastUserDetailService;
import org.orechou.fast.auth.translator.FastWebResponseExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author OreChou
 * @date 2021/07/27
 *
 * 认证服务器相关的安全配置类
 */
@Configuration
@EnableAuthorizationServer
public class FastAuthorizationServerConfigure extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private FastUserDetailService userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FastAuthProperties authProperties;
    @Autowired
    private FastWebResponseExceptionTranslator exceptionTranslator;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        FastClientsProperties[] clientsArray = authProperties.getClients();
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        if (ArrayUtils.isNotEmpty(clientsArray)) {
            for (FastClientsProperties client : clientsArray) {
                if (StringUtils.isBlank(client.getClient())) {
                    throw new Exception("client不能为空");
                }
                if (StringUtils.isBlank(client.getSecret())) {
                    throw new Exception("secret不能为空");
                }
                String[] grantTypes = StringUtils.splitByWholeSeparatorPreserveAllTokens(client.getGrantType(), ",");
                builder.withClient(client.getClient())
                        .secret(passwordEncoder.encode(client.getSecret()))
                        .authorizedGrantTypes(grantTypes)
                        .scopes(client.getScope())
                        .accessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds())
                        .refreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds());
            }
        }
    }

    @Override
    @SuppressWarnings("all")
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .userDetailsService(userDetailService)
                .authenticationManager(authenticationManager)
                .exceptionTranslator(exceptionTranslator);
    }

    @Bean
    public TokenStore tokenStore() {
//        return new RedisTokenStore(redisConnectionFactory);
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds());
        tokenServices.setRefreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds());
        return tokenServices;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        DefaultAccessTokenConverter defaultAccessTokenConverter = (DefaultAccessTokenConverter) accessTokenConverter.getAccessTokenConverter();
        DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
        userAuthenticationConverter.setUserDetailsService(userDetailService);
        defaultAccessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        accessTokenConverter.setSigningKey("fast");
        return accessTokenConverter;
    }

}
