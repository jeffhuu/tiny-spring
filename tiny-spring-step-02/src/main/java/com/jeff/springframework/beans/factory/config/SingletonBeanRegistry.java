package com.jeff.springframework.beans.factory.config;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:11
 *
 * 单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
