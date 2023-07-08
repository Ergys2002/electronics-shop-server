package com.electronicsshop.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email(message = "Email is not valid", regexp="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotBlank
    @Size(min = 10, max = 13, message = "Phone number must be between 10 and 13 characters")
    private String phone;
    @NotEmpty
    private String role;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid password format")
    private String password;
}
