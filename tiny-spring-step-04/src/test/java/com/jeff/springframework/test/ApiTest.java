package com.jeff.springframework.test;

import com.jeff.springframework.beans.PropertyValue;
import com.jeff.springframework.beans.PropertyValues;
import com.jeff.springframework.beans.factory.config.BeanDefinition;
import com.jeff.springframework.beans.factory.config.BeanReference;
import com.jeff.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.jeff.springframework.test.bean.UserDao;
import com.jeff.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();


    }

}
