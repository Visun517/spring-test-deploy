package lk.ijse.gdse71.bean.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements Injector{
//Property injection
//    @Autowired
    Di di;


    //Constructor through injection
//    @Autowired
    public Test2(Di di){
      this.di = di;
      System.out.println("Test2 Constructor");
    }




// Setter method through injection
//    @Autowired
//    public void setter(Di di){
//        this.di = di;
//    }




//Interface through injection
//    @Autowired
    @Override
    public void inject(Di di) {
        this.di = di;
    }




    public void test(){
        di.sayHello();
    }

}
