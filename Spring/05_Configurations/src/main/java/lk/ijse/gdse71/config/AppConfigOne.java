package lk.ijse.gdse71.config;

import lk.ijse.gdse71.bean.A;
import lk.ijse.gdse71.bean.B;
import lk.ijse.gdse71.bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfigOne {

//    @Bean
//    public SpringBeanOne getSpringBeanOne(){
//        return new SpringBeanOne();
//    }

    @Bean
    public A getA(){
        return new A();
    }

    @Bean
    public B getB(){
        return new B();
    }

}
