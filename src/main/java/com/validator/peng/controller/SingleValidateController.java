package com.validator.peng.controller;

import com.google.common.collect.ImmutableMap;
import com.validator.peng.verifier.annotation.IntegerRange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JRS : single validate Controller demo
 * <p>
 * add {@link Validated @Validated}
 *
 * @since 13 十月 2018
 */
@Slf4j
@Validated
@RestController
@RequestMapping("single")
public class SingleValidateController {

    /**
     * validate single filed
     * <p>
     * {@link Validated @Validated}
     *
     * @param number
     * @return
     */
    @GetMapping("/field")
    public String field(@NotNull Integer number) {
        log.info(String.valueOf(number));
        return ImmutableMap.of("result", Boolean.TRUE).toString();
    }

    /**
     * validate single filed by customer validator
     *
     * @param number
     * @return
     * @see com.validator.peng.verifier.annotation.IntegerRange
     */
    @GetMapping("/field/wired")
    public String wired(@IntegerRange Integer number) {
        log.info(String.valueOf(number));
        return ImmutableMap.of("result", Boolean.TRUE).toString();
    }

    public static void main(String[] args) {
        String result = Stream.of("1", "2").collect(Collectors.reducing(new String()
                , ob -> ob, (ob1, ob2) -> ob1 + ob2));
        System.out.println(result);
    }
}
