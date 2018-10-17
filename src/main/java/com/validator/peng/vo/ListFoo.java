package com.validator.peng.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

/**
 * List Foo
 *
 * @author wangyp
 * @since 16 October 2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListFoo {

    @Valid
    List<Foo> list;

}
