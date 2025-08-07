package lk.ijse.gdse71.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Visun")
public class SpringBean {

    public SpringBean() {
        System.out.println("Spring Bean Constructor");
    }

    public void test() {
        System.out.println("Spring Bean Test");
    }
}
