package org.orechou.fast.common.validator;

import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.common.annotation.IsMobile;
import org.orechou.fast.common.entity.RegexpConstant;
import org.orechou.fast.common.util.FastUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author OreChou
 * @date 2021/09/24
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return FastUtils.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
