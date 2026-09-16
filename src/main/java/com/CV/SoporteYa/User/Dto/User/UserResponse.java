package com.CV.SoporteYa.User.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String fullname;
    private String email;
    private String role;
}
