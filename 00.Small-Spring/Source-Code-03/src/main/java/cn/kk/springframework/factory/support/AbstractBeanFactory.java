package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.BeanFactory;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

/**
 * @Description
 * @Date 2021/5/31 13:54
 * @Version 1.0
 * @Author zhangkk
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

  @Override
  public Object getBean(String name) throws BeansException {
    Object bean = getSingleton(name);
    if (bean != null) {
      return bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return createBean(name, beanDefinition, null);
  }

  @Override
  public Object getBean(String name, Object[] args) throws BeansException {
    Object bean = getSingleton(name);
    if (bean != null) {
      return bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return createBean(name, beanDefinition, args);
  }

  protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);

  protected abstract BeanDefinition getBeanDefinition(String name);
}
