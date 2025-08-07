package lk.ijse.gdse71.config;

import lk.ijse.gdse71.bean.SpringBeanOne;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse71.bean")
public class AppConfig {

    // Inter bean dependency satisfy karanwa....

//    @Bean
//    public SpringBeanOne getSpringBeanOne(){
//        SpringBeanTwo springBeanTwo1 = getSpringBeanTwo();
//        SpringBeanTwo springBeanTwo2 = getSpringBeanTwo();
//        System.out.println(springBeanTwo1);// --> lk.ijse.gdse71.bean.SpringBeanTwo@f5958c9
//        System.out.println(springBeanTwo2);// --> lk.ijse.gdse71.bean.SpringBeanTwo@f5958c9
//        return new SpringBeanOne();
//    }
//
//    @Bean
//    public SpringBeanTwo getSpringBeanTwo(){
//        return new SpringBeanTwo();
//    }

}
