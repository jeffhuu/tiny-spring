package com.jeff.springframework;

import com.jeff.springframework.bean.UserService;
import org.junit.Test;

/**
 * @author Jeff Hu
 * @ClassName: ApiTest
 * @Description: TODO
 * @date 2022/6/20 21:57
 **/
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
