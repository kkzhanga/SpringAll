package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * interface.
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     *
     * 接口 ConfigurableBeanFactory 定义了 destroySingletons 销毁方法，
     * 并由 AbstractBeanFactory 继承的父类 DefaultSingletonBeanRegistry
     * 实现 ConfigurableBeanFactory 接口定义的 destroySingletons 方法。
     * 这种方式的设计可能多数程序员是没有用过的，都是用的谁实现接口谁完成实现类，
     * 而不是把实现接口的操作又交给继承的父类处理。所以这块还是蛮有意思的，是一种不错的隔离分层服务的设计方式
     *
     * 在学习和动手实践 Spring 框架学习的过程中，特别要注意的是它对接口和抽象类的把握和使用，
     * 尤其遇到类似，A继承B实现C时，C的接口方法由A继承的父类B实现，这样的操作都蛮有意思的。
     */
    void destroySingletons();
}
