package lk.ijse.gdse71.security_back_end.service;

import lk.ijse.gdse71.security_back_end.dto.AuthDto;
import lk.ijse.gdse71.security_back_end.dto.AuthResponseDto;
import lk.ijse.gdse71.security_back_end.dto.RegisterDto;
import lk.ijse.gdse71.security_back_end.entity.User;
import lk.ijse.gdse71.security_back_end.repository.UserRepository;
import lk.ijse.gdse71.security_back_end.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDto authenticate(AuthDto authDto) {
        User user = userRepository.findByUserName(authDto.getUsername())
                .orElseThrow(()->new RuntimeException("User not found"));


      if (!passwordEncoder.matches(
              authDto.getPassword(),
              user.getPassword())){
          throw new RuntimeException("Invalid password for user: " + authDto.getUsername());
      }

      String token = jwtUtil.generateToken(authDto.getUsername() , String.valueOf(user.getRole()));
      return new AuthResponseDto(token);
    }

    public String register(RegisterDto registerDto){
        if (userRepository.findByUserName(registerDto.getUserName())
                .isPresent()){
            throw new RuntimeException("User already exists with username: " + registerDto.getUserName());
        }
        User user = User.builder()
                .userName(registerDto.getUserName())
                .Password(passwordEncoder.encode(registerDto.getPassword()))
                .role(registerDto.getRole())
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }
}
