package cn.kk.springframework.beans.factory;

import cn.kk.springframework.beans.BeansException;


public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
