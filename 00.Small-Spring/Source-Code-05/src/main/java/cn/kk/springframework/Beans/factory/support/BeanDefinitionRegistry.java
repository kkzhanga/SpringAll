package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.Beans.BeansException;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

/**
 * @Description TODO
 * @Date 2021/6/4 11:19
 * @Version 1.0
 * @Author zhangkk
 */
public interface BeanDefinitionRegistry {
  /**
   * 向注册表中注册 BeanDefinition
   *
   * @param beanName
   * @param beanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  /**
   * 使用Bean名称查询BeanDefinition
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 判断是否包含指定名称的BeanDefinition
   * @param beanName
   * @return
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * Return the names of all beans defined in this registry.
   *
   * 返回注册表中所有的Bean名称
   */
  String[] getBeanDefinitionNames();


}
