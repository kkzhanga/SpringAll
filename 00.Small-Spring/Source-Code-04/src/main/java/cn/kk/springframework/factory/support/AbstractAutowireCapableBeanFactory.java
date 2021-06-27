package cn.kk.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.kk.springframework.BeansException;
import cn.kk.springframework.PropertyValue;
import cn.kk.springframework.PropertyValues;
import cn.kk.springframework.factory.config.BeanDefinition;
import cn.kk.springframework.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Description TODO
 * @Date 2021/6/4 11:20
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

      //属性填充
      applyPropertyValues(beanName, bean, beanDefinition);
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
      if (null != args && ctor.getParameterCount() == args.length) {
        constructorToUse = ctor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      if (null != propertyValues) {
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
          String name = propertyValue.getName();
          Object value = propertyValue.getValue();

          if (value instanceof BeanReference) {
            // 依赖的实例化
            BeanReference beanReference = (BeanReference) value;
            value = getBean(beanReference.getBeanName());
          }
          // 属性填充
          BeanUtil.setFieldValue(bean, name, value);
        }
      }
    } catch (Exception e) {
      throw new BeansException("Error setting property values：" + beanName);
    }
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }
}
