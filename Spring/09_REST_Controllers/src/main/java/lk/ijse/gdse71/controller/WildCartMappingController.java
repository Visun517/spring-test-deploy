package lk.ijse.gdse71.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wildCart")
public class WildCartMappingController {

    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/test/*/hello --> not worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/test//hello --> not worked

    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/test/aaa/hello -->  worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/test/123/hello ---> worked
    @GetMapping("test/*/hello")
    public String getMapping(){
        return "Wild-cart-GET";
    }

    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/hello/123/123 --> worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/hello/   /   --> worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/hello/==/==  --> worked

    //http://localhost:8080/09_REST_Controllers_Web_exploded/wildCart/hello/1  --> not worked
    @GetMapping("hello/*/*")
    public String getMapping2(){
        return "Wild-cart-GET-2";
    }
}
