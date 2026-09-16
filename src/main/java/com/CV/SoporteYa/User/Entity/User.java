package com.CV.SoporteYa.User.Entity;

import com.CV.SoporteYa.Tickets.Entity.Ticket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 30, nullable = false)
    private String fullname;

    @Column(unique = true,length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String role;
    //"ADMIN", "USER"

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<>();
}
