package com.jeff.springframework.beans.factory.config;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
