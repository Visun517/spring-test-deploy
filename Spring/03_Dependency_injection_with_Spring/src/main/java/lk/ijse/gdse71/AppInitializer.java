package lk.ijse.gdse71;

import lk.ijse.gdse71.bean.Boy;
import lk.ijse.gdse71.bean.DI.Test2;
import lk.ijse.gdse71.config.AppConFig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConFig.class);
        context.refresh();

//        Boy boy = context.getBean(Boy.class);
//        boy.chatWithGirl();

//        Test2 test2 = context.getBean(Test2.class);
//        test2.test();

        Test2 test2 = context.getBean(Test2.class);
        test2.test();

        context.registerShutdownHook();
    }
}