package lk.ijse.gdse71;

import lk.ijse.gdse71.bean.A;
import lk.ijse.gdse71.bean.SpringBeanOne;
import lk.ijse.gdse71.bean.SpringBeanTwo;
import lk.ijse.gdse71.config.AppConfig;
import lk.ijse.gdse71.config.AppConfigOne;
import lk.ijse.gdse71.config.AppConfigTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appinitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AppConfigOne.class);
//        context.register(AppConfigTwo.class);
        context.register(AppConfig.class);
        context.refresh();

//        SpringBeanOne springBeanOne = context.getBean(SpringBeanOne.class);
//        System.out.println(springBeanOne);
//
//        SpringBeanOne springBeanOne1 = context.getBean(SpringBeanOne.class);
//        System.out.println(springBeanOne1);
//
//        SpringBeanTwo springBeanTwo = context.getBean(SpringBeanTwo.class);
//        System.out.println(springBeanTwo);

        context.registerShutdownHook();

    }
}