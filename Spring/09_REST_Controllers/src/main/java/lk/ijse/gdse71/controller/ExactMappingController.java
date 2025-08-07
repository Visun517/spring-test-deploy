package lk.ijse.gdse71.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ExactMappingController {

    @GetMapping
    public String getMapping(){
        return "GET - 1";
    }
    @GetMapping("hello")
    public String getMapping2(){
        return "GET - 2";
    }
    @GetMapping("hello/three")
    public String getMapping3(){
        return "GET - 3";
    }
    @GetMapping("hello/three/four")
    public String getMapping4(){
        return "GET - 4";
    }
}
