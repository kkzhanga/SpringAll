package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description TODO
 * @Date 2021/5/31 16:08
 * @Version 1.0
 * @Author zhangkk
 */
public interface InstantiationStrategy {
  Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
