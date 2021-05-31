package cn.kk.springframework.factory.support;

import cn.kk.springframework.factory.config.BeanDefinition;

/**
 * @Description TODO
 * @Date 2021/5/31 14:43
 * @Version 1.0
 * @Author zhangkk
 */
public interface BeanDefinitionRegistry {

  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
