package lk.ijse.gdse71.security_back_end.dto;

import lk.ijse.gdse71.security_back_end.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {
    private String userName;
    private String password;
    private Role role;
}
