package com.jeff.tinyspring;

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

    public Object getBean(String key) {
        return beanDefinitionMap.get(key).getBean();
    }

    public void registerBeanDefinition() {

    }
}
