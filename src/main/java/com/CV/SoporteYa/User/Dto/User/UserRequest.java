package com.CV.SoporteYa.User.Dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "Fullname cant be blank")
    @Size(min = 5, max = 30, message = "Username must have between 5 to 30 characters")
    private String fullname;

    @NotBlank(message = "Email cant be blank")
    @Email(message = "Not valid email")
    private String email;

    @NotBlank(message = "Password cant be blank")
    @Size(min = 8, max = 30, message = "Password must have between 8 to 30 characters")
    private String password;
}
