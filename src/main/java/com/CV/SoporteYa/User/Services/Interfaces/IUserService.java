package com.CV.SoporteYa.User.Services.Interfaces;

import com.CV.SoporteYa.User.Dto.Others.MessageResponse;
import com.CV.SoporteYa.User.Dto.Register.RegisterRequest;
import com.CV.SoporteYa.User.Dto.User.UserResponse;
import com.CV.SoporteYa.User.Entity.User;

import java.util.List;

public interface IUserService {
    //Create
    MessageResponse createUser(RegisterRequest registerRequest);

    //Read
    List<UserResponse> getAllUser();
    User getUserById(Long id);

    //Update
    User updateUser(Long id, RegisterRequest registerRequest);

    //Delete
    MessageResponse deleteUser(Long id);
}
