package lk.ijse.gdse71.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("hello")
public class HelloController {
    public HelloController(){
        System.out.println("Hello Controller");
    }

    @GetMapping ("index")
    public String hello(){
        return "index";
    }

    @GetMapping("customer")
    public String hell2(){
        return "customer";
    }
//    @GetMapping("one")
//    public String testHello(){
//        return "Test Hello";
//    }
//
//    @GetMapping("two")
//    public String sayTest(){
//        return "Test..!";
//    }
}
