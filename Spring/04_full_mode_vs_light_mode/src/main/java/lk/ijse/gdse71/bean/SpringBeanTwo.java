package lk.ijse.gdse71.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


public class SpringBeanTwo implements DisposableBean , BeanNameAware , InitializingBean , ApplicationContextAware , BeanFactoryAware {

    public SpringBeanTwo() {
        System.out.println("SpringBeanTwo");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanTwo setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanTwo setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanTwo destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanTwo afterPropertiesSet");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanTwo setApplicationContext");
    }
}
