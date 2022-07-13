package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 *
 * Bean 实例化策略
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);

}
