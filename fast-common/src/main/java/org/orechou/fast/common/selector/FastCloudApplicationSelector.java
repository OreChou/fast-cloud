package org.orechou.fast.common.selector;

import org.orechou.fast.common.configure.FastAuthExceptionConfigure;
import org.orechou.fast.common.configure.FastOAuth2FeignConfigure;
import org.orechou.fast.common.configure.FastServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author OreChou
 * @date 2021/07/28
 */
public class FastCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                FastAuthExceptionConfigure.class.getName(),
                FastOAuth2FeignConfigure.class.getName(),
                FastServerProtectConfigure.class.getName()
        };
    }
}