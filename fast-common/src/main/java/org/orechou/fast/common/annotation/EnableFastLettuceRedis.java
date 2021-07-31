package org.orechou.fast.common.annotation;

import org.orechou.fast.common.configure.FastLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author OreChou
 * @date 2021/07/31
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastLettuceRedisConfigure.class)
public @interface EnableFastLettuceRedis {

}
