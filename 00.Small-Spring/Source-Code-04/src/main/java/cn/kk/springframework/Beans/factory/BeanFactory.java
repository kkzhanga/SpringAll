package cn.kk.springframework.Beans.factory;

import cn.kk.springframework.BeansException;


public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
