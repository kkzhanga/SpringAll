package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.BeanFactory;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

/**
 * @Description TODO
 * @Date 2021/6/4 10:41
 * @Version 1.0
 * @Author zhangkk
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

  @Override
  public Object getBean(String name) throws BeansException {
    return doGetBean(name, null);
  }

  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return doGetBean(name, args);
  }

  protected <T> T doGetBean(final String name, final Object[] args) {
    Object bean = getSingleton(name);
    if (bean != null) {
      return (T) bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return (T) createBean(name, beanDefinition, args);
  }

  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


}
