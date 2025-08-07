package lk.ijse.gdse71.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("Visun")
    private String name;

    public SpringBean(){
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }


    @Autowired(required = false)
    public SpringBean(@Value("Visun") String name ,@Value("10") int number ,@Value("true") boolean isActive) {
        System.out.println("SpringBean constructor " + name + " " + number + " " + isActive);
    }
    @Autowired(required = false)
    public SpringBean(@Value("Visun") String name ,@Value("10") int number) {
        System.out.println("SpringBean constructor " + name + " " + number );
    }


    // mehema autowired annation eka hema constructor ekatama use karala thiyenakota meha run karnane ,parameters wedima constructor eka.
}
