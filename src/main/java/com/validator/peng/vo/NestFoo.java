package com.validator.peng.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 嵌套对象
 *
 * @since 13 十月 2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NestFoo {

    @NotBlank
    private String mobile;

    @Valid
    @NotNull
    private Foo foo;
}
