package com.CV.SoporteYa.User.Services.Interfaces;

import com.CV.SoporteYa.User.Dto.Login.LoginRequest;
import com.CV.SoporteYa.User.Dto.Login.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);
}
