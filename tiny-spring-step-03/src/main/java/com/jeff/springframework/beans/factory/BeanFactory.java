package com.jeff.springframework.beans.factory;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/13
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object[] args);

}
