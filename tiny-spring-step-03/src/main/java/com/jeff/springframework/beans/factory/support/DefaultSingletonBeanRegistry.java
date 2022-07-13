package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:14
 *
 * 实现了单例注册表的 默认单例 Bean 注册类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void register(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
