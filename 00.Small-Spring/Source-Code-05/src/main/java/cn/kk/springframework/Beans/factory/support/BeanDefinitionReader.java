package cn.kk.springframework.Beans.factory.support;


import cn.kk.springframework.Beans.BeansException;
import cn.kk.springframework.io.Resource;
import cn.kk.springframework.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
