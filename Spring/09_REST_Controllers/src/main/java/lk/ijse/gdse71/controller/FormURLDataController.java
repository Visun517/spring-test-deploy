package lk.ijse.gdse71.controller;

import lk.ijse.gdse71.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("form")
public class FormURLDataController {

//    @PostMapping("save")
//    public String saveUser(@RequestParam("id") String id , @RequestParam("name") String name , @RequestParam("address") String address){
//        return "Id : " + id + " , Name : " + name + " , Address : " + address;
//    }

//    @PostMapping("save")
//    public String saveUser(@RequestParam Map<String , String> formData){
//        for (Map.Entry<String , String> entry : formData.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//            return entry.getKey() + " : " + entry.getValue();
//
//        }
//        return "save";
//    }

    @PostMapping("save")
    public String saveUser(@ModelAttribute UserDto userDto){
        System.out.println(userDto.toString());
        return userDto.toString();
    }
}
