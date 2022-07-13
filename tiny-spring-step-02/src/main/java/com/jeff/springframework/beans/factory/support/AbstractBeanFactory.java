package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.BeansException;
import com.jeff.springframework.beans.factory.BeanFactory;
import com.jeff.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:19
 *
 * BeanDefinition 注册表接口
 * BeanFactory 的定义由 AbstractBeanFactory 抽象类实现接口的 getBean 方法
 * 而 AbstractBeanFactory 又继承了实现了 SingletonBeanRegistry 的 DefaultSingletonBeanRegistry 类。
 * 这样 AbstractBeanFactory 抽象类就具备了单例 Bean 的注册功能。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 这里采用了模板方法的设计模式，预先定义好抽象方法，并在 getBean 方法中定义好这些抽象方法的调用顺序
     * getBean 是获取 bean 的方法，在 getBean 方法里调用 getSingleton
     *
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        // 尝试获取单例 bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        // 获取不到 bean，就要注册 bean
        // 先获取 bean 定义，再注册
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
