package lk.ijse.gdse71.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("param")
public class ParamController {

    @GetMapping(params ="id")
    public String getMapping(@RequestParam("id") String id){
        return id;
    }

    @GetMapping(params = {"id", "name"})
    public String getMapping2(@RequestParam("id") String id , @RequestParam("name") String name){
        return id + " " + name;
    }

    //http://localhost:8080/09_REST_Controllers_Web_exploded/param/id=12?name=Visun
    @GetMapping(path = "{id}" , params = "name")
    public String getMapping3(@PathVariable("id") String id , @RequestParam("name") String name){
        return id + " " + name;

        //---> me method eke karala thiyenne path variable eka param dekama use karala thiyenawa..
    }
}
