package lk.ijse.gdse71.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("${os.name}")
    private String name;

    // Resource bundle access karana heti
    @Value("${db.name}")
    private String name1;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
        System.out.println(name1);
    }
}
