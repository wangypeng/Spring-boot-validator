package com.validator.peng.verifier.annotation;


import com.validator.peng.verifier.IntegerRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Verifier of Integer Range
 * <p>
 * <p>
 * 必须要有{@link Constraint @Constraint} 约束注解，才会被spring识别到，validatedBy 必须指定验证器，
 * 验证器必须 extends {@link javax.validation.ConstraintValidator }
 *
 * 根据使用的位置，定义@Target,该注解主要是使用到了形参和属性
 *
 * @since 13 十月 2018
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Constraint(validatedBy = IntegerRangeValidator.class)
public @interface IntegerRange {

    String message() default "不是数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
