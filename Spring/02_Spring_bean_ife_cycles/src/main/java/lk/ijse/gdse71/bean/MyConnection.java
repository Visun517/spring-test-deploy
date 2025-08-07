package lk.ijse.gdse71.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean , BeanNameAware , BeanFactoryAware , ApplicationContextAware , InitializingBean {
     public  MyConnection(){
         System.out.println("My connection constructor step 01");
         // Insatantiation 01 step
     }


     // Populate of perpertues ( apita balanna vidiyak ne) 02 step


    @Override
    public void setBeanName(String name) {
         //bean name aware --> bean id --> 03 step
            System.out.println("Bean Name is : "+name + " step 03");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
         // Bean factory aware ---> 04 step (Dependency Injection)
        System.out.println("set Bean factory call step 04");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         // ApplicationContextAware --> 05 step (AOS set up)
        System.out.println("set application context call step 05");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
         //InitializingBean --> 06 step
        System.out.println("MyConnection Bean  is initialized step 06");
    }

    @Override
    public void destroy() throws Exception {
         //DisposableBean --> 07 step
        System.out.println("MyConnection is Destroyed step 07");
    }


}
