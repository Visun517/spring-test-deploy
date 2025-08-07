package lk.ijse.gdse71.bean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class TestBean1 implements DisposableBean {

    public TestBean1(){
        System.out.println("Test Bean 1 Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Test Bean 1 Destroyed");
    }
}
