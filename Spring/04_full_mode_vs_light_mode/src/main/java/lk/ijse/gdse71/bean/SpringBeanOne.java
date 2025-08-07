package lk.ijse.gdse71.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


public class SpringBeanOne  implements DisposableBean, BeanNameAware, InitializingBean, ApplicationContextAware, BeanFactoryAware {

    public SpringBeanOne() {
        System.out.println("SpringBeanOne");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanOne setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanOne setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanOne destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanOne setApplicationContext");
    }
}
