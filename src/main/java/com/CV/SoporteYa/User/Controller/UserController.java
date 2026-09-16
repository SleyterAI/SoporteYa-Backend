package com.CV.SoporteYa.User.Controller;


import com.CV.SoporteYa.User.Dto.Others.MessageResponse;
import com.CV.SoporteYa.User.Dto.Others.RolNMessageResponse;
import com.CV.SoporteYa.User.Dto.Register.RegisterRequest;
import com.CV.SoporteYa.User.Dto.User.UserResponse;
import com.CV.SoporteYa.User.Entity.User;
import com.CV.SoporteYa.User.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> createUser(@Valid @RequestBody RegisterRequest registerRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(registerRequestDto));
    }

    @GetMapping
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PatchMapping("/{id}/role")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<RolNMessageResponse> updateRole(
            @PathVariable Long id, @RequestBody User newRole) {

        return ResponseEntity.ok(userService.updateRole(id, newRole.getRole()));
    }

    @DeleteMapping("/{id}")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
