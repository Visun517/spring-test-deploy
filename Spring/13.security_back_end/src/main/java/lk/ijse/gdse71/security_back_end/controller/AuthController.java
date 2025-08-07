package lk.ijse.gdse71.security_back_end.controller;

import lk.ijse.gdse71.security_back_end.dto.ApiResponse;
import lk.ijse.gdse71.security_back_end.dto.AuthDto;
import lk.ijse.gdse71.security_back_end.dto.RegisterDto;
import lk.ijse.gdse71.security_back_end.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(
            new ApiResponse(
                201,
                "User registered successfully",
                authService.register(registerDto)
            )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody AuthDto authDto) {

        return ResponseEntity.ok(
                new ApiResponse(
                        201,
                        "User registered successfully",
                        authService.authenticate(authDto)
                )
        );
    }
}
