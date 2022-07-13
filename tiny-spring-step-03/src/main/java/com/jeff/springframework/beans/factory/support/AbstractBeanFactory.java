package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.BeanFactory;
import com.jeff.springframework.beans.factory.config.BeanDefinition;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object[] args) {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (null != bean) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanDefinition, beanName, args);
    }

    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(BeanDefinition beanDefinition, String beanName, Object[] args);

}
