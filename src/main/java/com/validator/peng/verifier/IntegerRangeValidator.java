package com.validator.peng.verifier;

import com.validator.peng.service.ValidateService;
import com.validator.peng.verifier.annotation.IntegerRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * Customer validator
 * <p>
 * 实现{@link ConstraintValidator},定义两个泛型：
 * 一个是引用的验证注解类型，本项目中{@link IntegerRange}
 * 一个是验证验证参数的类型
 *
 * @since 13 十月 2018
 */
@Component
public class IntegerRangeValidator implements ConstraintValidator<IntegerRange, Integer> {

    @Autowired
    private ValidateService ValidateService;

    /**
     * {@link ConstraintValidator}中默认initialize方法是default的，可以不必须实现，
     * 本方法是初始化方法，在构造函数执行之后执行；
     *
     * @param integerRange
     */
    @Override
    public void initialize(IntegerRange integerRange) {

    }

    /**
     * 真正验证的方法，形参为参数值，和验证上下文
     *
     * @param value   参数值
     * @param context 验证上下文
     * @return true/false 验证结果
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return false;        //  HV000028: Unexpected exception during isValid call
        }
        return ValidateService.isOutRange(value);
    }
}
