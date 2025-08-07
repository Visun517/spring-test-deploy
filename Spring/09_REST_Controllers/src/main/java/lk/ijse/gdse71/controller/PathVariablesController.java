package lk.ijse.gdse71.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "path")
public class PathVariablesController {

    //http://localhost:8080/09_REST_Controllers_Web_exploded/path/id=11 --->worked
    @GetMapping(path = "{id}")
    public String getMapping(@PathVariable("id") String id){
        System.out.println(id);
        return id;
    }

    @GetMapping(path = "{name}/{age}")
    public String getMapping2(@PathVariable("name") String name , @PathVariable("age") int age){
        return name + " " + age;
    }

    //http://localhost:8080/09_REST_Controllers_Web_exploded/path/customre/I001
    @GetMapping(path = "customer/{id:[I][0-9]{3}}")
    public String getMapping3(@PathVariable("id") String id){
        return "Id is : "+ id;
    }

    //http://localhost:8080/09_REST_Controllers_Web_exploded/path/item/I001/branch/Panadura
    @GetMapping(path = "item/{code}/branch/{city}")
    public String getMapping4(@PathVariable("code") String code , @PathVariable("city") String city){
        return "Code : "+ code + " City : "+ city;
    }

    @GetMapping(path = "items/{code:[I][0-9]{3}}/branche/{city:[a-zA-Z]{20}}")
    public String getMapping5(@PathVariable("code") String code , @PathVariable("city") String city){
        return "Code : "+ code + " City : "+ city;
    }

    // ---> Me controller eke use karala thiyena validation tika weda karanne ne , eka gena hoayanna , validationn tika hadanna
}
