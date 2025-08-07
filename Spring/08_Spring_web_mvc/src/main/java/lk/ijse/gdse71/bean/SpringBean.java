package lk.ijse.gdse71.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements DisposableBean , BeanFactoryAware , BeanNameAware , ApplicationContextAware  , InitializingBean  {
    private SpringBean() {
        System.out.println("Spring Bean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBean setBeanFactory");

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBean setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBean afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBean setApplicationContext");
    }
}
