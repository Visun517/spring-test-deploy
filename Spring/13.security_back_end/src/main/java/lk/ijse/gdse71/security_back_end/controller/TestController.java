package lk.ijse.gdse71.security_back_end.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@CrossOrigin(origins = "http://localhost:63342") // Add this
public class TestController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String testAdmin() {
        return "Test endpoint is working-admin!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String testUser() {
        return "Test endpoint is working-user!";
    }
}
