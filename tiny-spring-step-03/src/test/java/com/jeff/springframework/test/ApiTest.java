package com.jeff.springframework.test;

import com.jeff.springframework.beans.factory.config.BeanDefinition;
import com.jeff.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.jeff.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.创建 BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 2.注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) factory.getBean("userService", "jeff");
        userService.queryUserInfo();

    }

}
