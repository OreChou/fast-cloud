package org.orechou.fast.common.annotation;

import org.orechou.fast.common.selector.FastCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author OreChou
 * @date 2021/07/28
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastCloudApplicationSelector.class)
public @interface FastCloudApplication {
}
