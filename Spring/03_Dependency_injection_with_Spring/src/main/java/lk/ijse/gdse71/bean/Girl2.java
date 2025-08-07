package lk.ijse.gdse71.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl2 implements Agreement{

    public Girl2(){
        System.out.println("Girl1 Constructor");
    }
    public void chat(){
        System.out.println("Chatting....2");
    }
}
