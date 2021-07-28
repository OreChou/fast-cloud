package org.orechou.fast.common.annotation;

import org.orechou.fast.common.configure.FastAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author OreChou
 * @date 2021/07/27
 *
 * 认证类型异常翻译
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastAuthExceptionConfigure.class)
public @interface EnableFastAuthExceptionHandler {

}
