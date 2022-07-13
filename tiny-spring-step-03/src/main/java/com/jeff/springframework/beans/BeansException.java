package com.jeff.springframework.beans;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:05
 *
 * 定义 Bean 异常
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
