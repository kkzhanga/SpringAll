package cn.kk.springframework;

import cn.kk.springframework.bean.UserService;
import cn.kk.springframework.factory.config.BeanDefinition;
import cn.kk.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;


public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取无参bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 3.获取有参bean
       /* UserService userService = (UserService) beanFactory.getBean("userService", new Object[]{"小傅哥"});
        userService.queryUserInfo();*/
    }
}