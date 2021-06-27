package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description TODO
 * @Date 2021/5/31 14:32
 * @Version 1.0
 * @Author zhangkk
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
    Object bean = null;
    try {
      //bean = beanDefinition.getBeanClass().newInstance();
      bean = createBeanInstance(beanDefinition, beanName, args);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }

    //放入缓存
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
    Constructor constructorToUse = null;
    Class<?> beanClass = beanDefinition.getBeanClass();
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor ctor : declaredConstructors) {
      if (null != args && ctor.getParameterTypes().length == args.length) {
        constructorToUse = ctor;
        break;
      }
    }
    return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
  }

}
