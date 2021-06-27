package cn.kk.springframework.Beans.factory.config;

/**
 * @Description TODO
 * @Date 2021/5/31 14:12
 * @Version 1.0
 * @Author zhangkk
 */
public interface SingletonBeanRegistry {

  Object getSingleton(String beanName);

}
