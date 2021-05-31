package cn.kk.springframework.factory.support;

import cn.kk.springframework.BeansException;
import cn.kk.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2021/5/31 14:46
 * @Version 1.0
 * @Author zhangkk
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
  private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

  @Override
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null){
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }

    return beanDefinition;
  }


}
