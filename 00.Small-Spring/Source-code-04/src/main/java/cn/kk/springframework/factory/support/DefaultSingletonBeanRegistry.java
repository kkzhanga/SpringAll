package cn.kk.springframework.factory.support;

import cn.kk.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;


/**
 * @Description
 * @Date 2021/6/4 10:45
 * @Version 1.0
 * @Author zhangkk
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
  private Map<String, Object> singletonObjects = new HashMap();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
