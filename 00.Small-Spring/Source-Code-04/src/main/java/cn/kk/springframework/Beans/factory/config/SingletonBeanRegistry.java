package cn.kk.springframework.Beans.factory.config;

/**
 * @Description
 * @Date 2021/6/4 10:44
 * @Version 1.0
 * @Author zhangkk
 */
public interface SingletonBeanRegistry {
  Object getSingleton(String beanName);
}
