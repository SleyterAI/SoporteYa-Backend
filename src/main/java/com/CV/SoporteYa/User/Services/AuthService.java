package com.CV.SoporteYa.User.Services;


import com.CV.SoporteYa.Security.Jwt.JwtService;
import com.CV.SoporteYa.User.Dto.Login.LoginRequest;
import com.CV.SoporteYa.User.Dto.Login.LoginResponse;
import com.CV.SoporteYa.User.Services.Interfaces.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                ));
        String token = jwtService.generarToken(authentication);
        return new LoginResponse(token);
    }
}
