package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.BeansException;
import com.jeff.springframework.beans.factory.BeanFactory;
import com.jeff.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:19
 *
 * BeanDefinition 注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
