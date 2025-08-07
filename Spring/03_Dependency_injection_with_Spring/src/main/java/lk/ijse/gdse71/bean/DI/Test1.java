package lk.ijse.gdse71.bean.DI;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements Di {
    public Test1(){
        System.out.println("Test1 Constructor");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
