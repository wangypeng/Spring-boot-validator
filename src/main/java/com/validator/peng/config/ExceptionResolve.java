package com.validator.peng.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 *
 * @see RestControllerAdvice
 * @see ExceptionHandler
 * @since 13 十月 2018
 */
@RestControllerAdvice
@Slf4j
public class ExceptionResolve {

    /**
     * 单个参数验证
     *
     * @param request 请求体
     * @param e       异常对象
     * @return 返回消息
     * @see ConstraintViolationException
     */
    @Order(1)
    @ExceptionHandler(ConstraintViolationException.class)
    public String constraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
                          .map(ob -> new StringBuilder(ob.getMessage()).append(","))
                          .reduce((ob1, ob2) -> ob1.append(ob2))
                          .orElse(new StringBuilder("参数异常")).toString();
        return message.substring(0, message.length() - 1);
    }

    /**
     * 对象绑定异常
     *
     * @param request 请求体
     * @param e       异常对象
     * @return 返回消息
     * @see BindException
     */
    @Order(2)
    @ExceptionHandler(BindException.class)
    public String bindException(HttpServletRequest request, BindException e) {
        String message = e.getAllErrors().stream()
                          .map(ob -> new StringBuilder().append(ob.getDefaultMessage())
                                                        .append(","))
                          .reduce((ob1, ob2) -> ob1.append(ob2))
                          .orElse(new StringBuilder("参数异常")).toString();
        return message.substring(0, message.length() - 1);
    }

    /**
     * {@link org.springframework.web.bind.annotation.RequestBody} 对象参数
     *
     * @param request 请求体
     * @param e       异常对象
     * @return 消息
     * @see MethodArgumentNotValidException
     * @see org.springframework.web.bind.annotation.RequestBody
     */
    @Order(3)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream()
                          .map(ob -> new StringBuilder().append(ob.getDefaultMessage()).append(","))
                          .reduce((ob1, ob2) -> ob1.append(ob2))
                          .orElse(new StringBuilder("参数异常")).toString();
        return message.substring(0, message.length() - 1);
    }

    @Order
    @ExceptionHandler(Exception.class)
    public String finalException(HttpServletRequest request, Exception e) {
        return "系统异常";
    }
}
