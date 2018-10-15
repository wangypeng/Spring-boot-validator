package com.validator.peng.vo;

import com.validator.peng.verifier.annotation.IntegerRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * validate object
 *
 * @since 13 十月 2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GroupSequence({Foo.class, Foo.GroupA.class})
public class Foo {

    @NotNull(groups = {GroupA.class})
    @Size(groups = {GroupA.class}, min = 1, max = 20, message = "超出范围")
    private String sex;

    @NotBlank(message = "name不能为空")
    private String name;

    @IntegerRange
    private Integer age;

    public interface GroupA {

    }
}
