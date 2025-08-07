package lk.ijse.gdse71.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanThree {

    public SpringBeanThree() {
        System.out.println("SpringBeanThree constructor");
    }

//     Inter Bean dependency not satisfied...
    @Bean
    public SpringBeanOne getSpringBeanOne(){
        SpringBeanTwo springBeanTwo1 = getSpringBeanTwo(); //-->lk.ijse.gdse71.bean.SpringBeanTwo@6b26e945
        SpringBeanTwo springBeanTwo2 = getSpringBeanTwo(); //-->lk.ijse.gdse71.bean.SpringBeanTwo@63a65a25
        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        return new SpringBeanTwo();
    }
}
