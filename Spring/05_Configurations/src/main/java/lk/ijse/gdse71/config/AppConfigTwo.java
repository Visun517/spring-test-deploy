package lk.ijse.gdse71.config;

import lk.ijse.gdse71.bean.C;
import lk.ijse.gdse71.bean.D;
import lk.ijse.gdse71.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfigTwo {

//    @Bean
//    public SpringBeanTwo springBeanTwo(){
//        return new SpringBeanTwo();
//    }

    @Bean
    public C getC(){
        return new C();
    }

    @Bean
    public D getD(){
        return new D();
    }

}
