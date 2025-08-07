package lk.ijse.gdse71.security_back_end.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String Password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
