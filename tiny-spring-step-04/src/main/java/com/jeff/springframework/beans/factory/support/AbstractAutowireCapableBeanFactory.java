package com.jeff.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.jeff.springframework.beans.BeansException;
import com.jeff.springframework.beans.PropertyValue;
import com.jeff.springframework.beans.PropertyValues;
import com.jeff.springframework.beans.factory.config.BeanDefinition;
import com.jeff.springframework.beans.factory.config.BeanReference;
import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    public Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(name, beanDefinition, args);
            applyPropertyValues(name, bean, beanDefinition);
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

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
