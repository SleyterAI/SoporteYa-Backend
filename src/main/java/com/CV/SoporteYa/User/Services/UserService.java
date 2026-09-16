package com.CV.SoporteYa.User.Services;

import com.CV.SoporteYa.GlobalException.DuplicateResourceException;
import com.CV.SoporteYa.User.Dto.Others.MessageResponse;
import com.CV.SoporteYa.User.Dto.Others.RolNMessageResponse;
import com.CV.SoporteYa.User.Dto.Register.RegisterRequest;
import com.CV.SoporteYa.User.Dto.User.UserResponse;
import com.CV.SoporteYa.User.Entity.User;
import com.CV.SoporteYa.User.Repository.UserRepository;
import com.CV.SoporteYa.User.Services.Interfaces.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MessageResponse createUser(RegisterRequest registerRequestDto) {
        if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (userRepository.existsByFullname(registerRequestDto.getFullname())) {
            throw new DuplicateResourceException("Username already exists");
        }
        User user = new User();
        user.setFullname(registerRequestDto.getFullname());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(
                passwordEncoder.encode(registerRequestDto.getPassword())
        );
        user.setRole("ADMIN");

        userRepository.save(user);

        return new MessageResponse("User created correctly");
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getFullname(),
                        user.getEmail(),
                        user.getRole()
                ))
                .toList();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(Long id, RegisterRequest registerRequestDto) {
        return null;
    }

    @Override
    public MessageResponse deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User doesnt exist");
        }
        userRepository.deleteById(id);
        return new MessageResponse("User deleted correctly");
    }

    public RolNMessageResponse updateRole(Long id, String role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User doesnt exist"));

        user.setRole(role);
        User promotedUser = userRepository.save(user);
        return new RolNMessageResponse("User promoted correctly: ", promotedUser.getRole());
    }
}
