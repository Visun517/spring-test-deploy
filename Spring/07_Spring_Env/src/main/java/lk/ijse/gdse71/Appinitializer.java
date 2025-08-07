package lk.ijse.gdse71;

import lk.ijse.gdse71.bean.SpringBean;
import lk.ijse.gdse71.confi.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class Appinitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        //System env variables " System.getenv() " meken return wenne Map ekka apita map eka iterate karala env variables balanna
//        Map<String, String> env = System.getenv();
//        for (String key : env.keySet()) {
//            System.out.println(key + ": " + env.get(key));
//        }

        // Java env variables
            //System.getProperties().list(System.out);

        SpringBean springBean = context.getBean(SpringBean.class);




        //Resources bundle




        context.registerShutdownHook();

    }
}