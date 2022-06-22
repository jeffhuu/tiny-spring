package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: tiny-spring
 * @description:
 * @author: Jeff Hu 2022/06/21 13:57
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
