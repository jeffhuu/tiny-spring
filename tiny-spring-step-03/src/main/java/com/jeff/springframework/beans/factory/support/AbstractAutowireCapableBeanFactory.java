package com.jeff.springframework.beans.factory.support;

import com.jeff.springframework.beans.BeansException;
import com.jeff.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    public Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(name, beanDefinition, args);
        } catch (BeansException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 往容器中添加创建好的 bean，以便于下次直接获取
        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructor = null;
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, name, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
