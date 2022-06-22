package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.BeansException;
import com.jeff.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:33
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
