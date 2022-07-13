package com.jeff.springframework.beans.factory.config;

/**
 * @program: tiny-spring
 * @description:
 * @author: Jeff Hu 2022/06/21 14:00
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}