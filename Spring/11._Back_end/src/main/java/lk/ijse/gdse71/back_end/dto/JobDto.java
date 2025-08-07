package lk.ijse.gdse71.back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDto {
    private Integer id;
    @NotBlank(message = "Job title cannot be blank") // @NotNull
    private String jobTitle;
    @NotBlank(message = "Company name cannot be blank") // @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Company name can only contain letters, numbers, and spaces")
    private String company;
    private String location;
    private String type;
    @Size(max = 500 , min = 10, message = "Job description cannot exceed 500 characters")
    private String jobDescription;
    private String status;
}
