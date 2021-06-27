package cn.kk.springframework.Beans.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2021/6/4 14:01
 * @Version 1.0
 * @Author zhangkk
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

  private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

  @Override
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null) {
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }

    return beanDefinition;
  }
}
