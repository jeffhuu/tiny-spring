package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 */
public class AbstractAutowireCapableBeanFactory extends DefaultListableBeanFactory{

    @Override
    public Object createBean(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getTypeParameters().length == args.length) {

            }
        }
    }
}
