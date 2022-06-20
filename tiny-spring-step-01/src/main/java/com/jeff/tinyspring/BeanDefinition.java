package com.jeff.tinyspring;

/**
 * @author Jeff Hu
 * @ClassName: BeanDefinition
 * @Description: TODO
 * @date 2022/6/17 23:47
 **/
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
