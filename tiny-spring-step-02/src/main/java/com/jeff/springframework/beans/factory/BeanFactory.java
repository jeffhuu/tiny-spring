package com.jeff.springframework.beans.factory;

import com.jeff.springframework.beans.BeansException;

/**
 * 获取 Bean 的工厂接口定义
 */
public interface BeanFactory {

    // 获取 bean 对象
    Object getBean(String name) throws BeansException;

}
