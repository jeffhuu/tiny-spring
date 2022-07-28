package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);

}
