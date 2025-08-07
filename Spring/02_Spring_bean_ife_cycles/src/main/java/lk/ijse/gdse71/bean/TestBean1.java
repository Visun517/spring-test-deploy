package lk.ijse.gdse71.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class TestBean1 {
    public TestBean1() {
        System.out.println("Test bean 01 constructor");
    }
}
