package cn.kk.springframework.Beans.factory.config;


import cn.kk.springframework.Beans.factory.BeanFactory;

/**
 * Extension of the {@link cn.kk.springframework.Beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}
