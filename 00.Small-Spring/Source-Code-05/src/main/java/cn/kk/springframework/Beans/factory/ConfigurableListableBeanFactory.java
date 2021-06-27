package cn.kk.springframework.Beans.factory;


import cn.kk.springframework.Beans.BeansException;
import cn.kk.springframework.Beans.factory.config.AutowireCapableBeanFactory;
import cn.kk.springframework.Beans.factory.config.BeanDefinition;
import cn.kk.springframework.Beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
