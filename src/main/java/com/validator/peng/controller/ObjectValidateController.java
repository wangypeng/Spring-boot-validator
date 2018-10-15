package com.validator.peng.controller;

import com.google.common.collect.ImmutableMap;
import com.sun.istack.internal.Nullable;
import com.validator.peng.vo.Foo;
import com.validator.peng.vo.NestFoo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Object validate Controller
 *
 * @since 13 十月 2018
 */
@Slf4j
@RestController
@RequestMapping("object")
public class ObjectValidateController {

    /**
     * 整个对象验证
     *
     * @param foo
     * @return
     */
    @GetMapping("all")
    public String all(@Validated Foo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }

    /**
     * 分组验证
     *
     * @param foo
     * @return
     */
    @GetMapping("group")
    public String group(@Validated(Foo.GroupA.class) Foo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }

    /**
     * post request body
     * <p>
     * requestBody 验证对象全部域验证时候，对有group分组属性的域忽略，需要增加相同无组的注解
     *
     * @param foo
     * @return
     */
    @PostMapping("requestBody")
    public String requestBody(@Valid @RequestBody Foo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }

    /**
     * post request body group
     *
     * @param foo
     * @return
     */
    @PostMapping("requestBody/group")
    public String requestBodyGroup(@Validated(Foo.GroupA.class) @RequestBody Foo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }

    /**
     * 嵌套验证
     *
     * @param foo
     * @return
     */
    @PostMapping("nest")
    public String nest(@Validated @RequestBody NestFoo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }

    /**
     * 嵌套 分组
     *
     * @param foo
     * @return
     */
    @PostMapping("nest/group")
    public String nestGroup(@Validated(Foo.GroupA.class) @RequestBody NestFoo foo) {
        log.info(foo.toString());
        return ImmutableMap.of("result", true).toString();
    }


    /**
     * ide 中定义 @Nullable
     *
     * @param args
     */
    public void main(String[] args) {
        @Nullable Object a = null;
        check(a);
    }

    public static void check(@NotNull Object a) {

    }

}
