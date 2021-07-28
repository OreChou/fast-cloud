package org.orechou.fast.common.annotation;

import org.orechou.fast.common.configure.FastServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author OreChou
 * @date 2021/07/28
 *
 * 开启微服务防护，避免客户端绕过网关直接请求微服务
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastServerProtectConfigure.class)
public @interface EnableFastServerProtect {

}
