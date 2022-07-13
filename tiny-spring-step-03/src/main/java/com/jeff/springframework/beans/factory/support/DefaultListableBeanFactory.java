package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.BeanDefinition;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 */
public abstract class DefaultListableBeanFactory extends AbstractBeanFactory{

    private Map<String, BeanDefinition> definitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return definitionMap.get(beanName);
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        definitionMap.put(beanName, beanDefinition);
    }

}
