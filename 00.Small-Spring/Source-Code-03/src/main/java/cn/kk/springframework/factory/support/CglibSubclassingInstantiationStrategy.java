package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description TODO
 * @Date 2021/5/31 16:11
 * @Version 1.0
 * @Author zhangkk
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
  @Override
  public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
    /*Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    enhancer.setCallback(new NoOp() {
      @Override
      public int hashCode() {
        return super.hashCode();
      }
    });
    if (null == ctor) return enhancer.create();
    return enhancer.create(ctor.getParameterTypes(), args);*/
    return null;
  }
}
