package cn.kk.springframework.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description TODO
 * @Date 2021/6/4 13:28
 * @Version 1.0
 * @Author zhangkk
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
  @Override
  public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
    Class clazz = beanDefinition.getBeanClass();
    try {
      if (null != ctor) {
        return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
      } else {
        return clazz.getDeclaredConstructor().newInstance();
      }
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
    }
  }
}
