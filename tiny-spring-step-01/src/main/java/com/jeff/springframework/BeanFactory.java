package com.jeff.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jeff Hu
 * @ClassName: BeanFactory
 * @Description: TODO
 * @date 2022/6/18 00:05
 **/
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
