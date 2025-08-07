package lk.ijse.gdse71;

import lk.ijse.gdse71.bean.MyConnection;
import lk.ijse.gdse71.bean.SpringBean;
import lk.ijse.gdse71.bean.TestBean1;
import lk.ijse.gdse71.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        SpringBean springBean = context.getBean(SpringBean.class);
//        System.out.println(springBean);
////        SpringBean springBean1 = context.getBean(SpringBean.class);
////        System.out.println(springBean);
////
////        System.out.println(springBean1);
//
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//
////        TestBean1 testBean2 = context.getBean(TestBean1.class);
////        System.out.println(testBean2);
//
////        Runtime.getRuntime().addShutdownHook(new Thread(){
////            @Override
////            public void run() {
////                context.close();
////                // mekat kiyanne register shutDown hook eka kiyala. (methanadi wenne jvm eka eka run wela iwara unata passe context eka close karane eka , ethakota error eka enne ne, )
////                // meka eka kramyak thiarayi
////            }
////        });
//
//        context.registerShutdownHook();

//        TestBean1 testBean2 = context.getBean(TestBean1.class);
//        System.out.println(testBean2); // error ( note ekata add karanna)



        //Conetxt ekan bean eka ganna krama

//        //01
//        SpringBean springBean = context.getBean(SpringBean.class);
//        System.out.println("Spring Bean :"+springBean);
//
//        //02
//        SpringBean springBean1 = (SpringBean) context.getBean("springBean");// methanadi use karala thiyenne bean id eka ( bean clz eka hadana name eke 1 letter eka simple)
//        System.out.println("Spring Bean 1 :"+springBean1);
//
//        //03
//        SpringBean springBean2 = context.getBean("springBean" , SpringBean.class);
//        System.out.println("Spring Bean 2 :"+springBean2);



        ////////////////////////
//
//        MyConnection myConnection = (MyConnection) context.getBean("myConnection");
//        System.out.println("My connection wena framework ekaking gaththa bean eka :"+myConnection);
//
//        MyConnection myConnection2 = (MyConnection) context.getBean("myConnection" , MyConnection.class);// mehma karannth puluwan

//        (MyConnection) context.getBean("myConnection"); --> methandi use karnnne appConfig eke myconnection eka return karana method name eka....



        ///////////////////////////////////////////////// ( bean scope ---> //@Scope("prototype")) ///////////////////////////////////

        //01.  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        //02.  @Scope("prototype")

       // bean scope use karala nathi nisa methana thiyenna singleton behavior ekak
        SpringBean springBean1 = context.getBean(SpringBean.class);
        System.out.println("Spring Bean 1 :"+springBean1); //Spring Bean 1 :lk.ijse.gdse71.bean.SpringBean@7880cdf3
        SpringBean springBean2 = context.getBean(SpringBean.class);
        System.out.println("Spring Bean 2 :"+springBean2); //Spring Bean 2 :lk.ijse.gdse71.bean.SpringBean@7880cdf3

        // bena scope use karla thiyena nisa TestBean1 kiyana bean eka weda karanne request eken request eka bean ekak create wenawa
        TestBean1 testBean1 = context.getBean(TestBean1.class);
        System.out.println(testBean1); //Test Bean 1 Constructor -->lk.ijse.gdse71.bean.TestBean1@2473d930
        TestBean1 testBean2 = context.getBean(TestBean1.class);
        System.out.println(testBean2); // Test Bean 1 Constructor -->lk.ijse.gdse71.bean.TestBean1@35047d03


        /// Testing
        MyConnection myConnection1 = context.getBean("MyConnection" , MyConnection.class);
        System.out.println(myConnection1);
        MyConnection myConnection2 = context.getBean("MyConnection" , MyConnection.class);
        System.out.println(myConnection2);




        context.registerShutdownHook();
    }
}