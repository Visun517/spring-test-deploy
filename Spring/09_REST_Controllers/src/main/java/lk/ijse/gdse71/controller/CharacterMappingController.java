package lk.ijse.gdse71.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("char")
public class CharacterMappingController {
    //http://localhost:8080/09_REST_Controllers_Web_exploded/char/item/I123  --->worked
    // http://localhost:8080/09_REST_Controllers_Web_exploded/char/item/Iabc  --->worked
    // http://localhost:8080/09_REST_Controllers_Web_exploded/char/item/I@@@ --->worked

    // http://localhost:8080/09_REST_Controllers_Web_exploded/char/item/i123 --->not-worked
    // http://localhost:8080/09_REST_Controllers_Web_exploded/char/item/I1234 --->not-worked
    @GetMapping("item/I???")
    public String sayHello(){
        return "syaHello";
    }

    //http://localhost:8080/09_REST_Controllers_Web_exploded/char/    /search ---> worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/char/1234/search ---> worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/char/abcd/search ---> worked
    //http://localhost:8080/09_REST_Controllers_Web_exploded/char/@@@@/search ---> worked

    //http://localhost:8080/09_REST_Controllers_Web_exploded/char//search  --->not-worked
    @GetMapping("????/search")
    public String sayHello2(){
        return "syaHello - 2";
    }
}
