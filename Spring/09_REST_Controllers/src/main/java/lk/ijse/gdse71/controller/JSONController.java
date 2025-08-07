package lk.ijse.gdse71.controller;

import lk.ijse.gdse71.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("json")
public class JSONController {

    private UserDto userDto;

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonMapping(@RequestBody UserDto userDto){
        this.userDto = userDto;
        System.out.println(userDto.toString());
        return userDto.toString();
    }

    @GetMapping("get")
    public UserDto jsonGet(){
        return userDto;
    }
}
