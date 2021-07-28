package org.orechou.fast.common.annotation;

import org.orechou.fast.common.configure.FastOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author OreChou
 * @date 2021/07/27
 *
 * 开启带令牌的Feign请求，避免微服务内部调用出现401异常
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastOAuth2FeignConfigure.class)
public @interface EnableFastOauth2FeignClient {
}
