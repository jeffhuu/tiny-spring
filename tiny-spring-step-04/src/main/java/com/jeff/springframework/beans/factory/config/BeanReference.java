package com.jeff.springframework.beans.factory.config;

/**
 * @date 2022/07/28
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
