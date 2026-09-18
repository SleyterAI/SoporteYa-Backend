package com.CV.SoporteYa.Tickets.Dto;

import com.CV.SoporteYa.Tickets.Entity.Categoria;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import com.CV.SoporteYa.User.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {
    @NotBlank(message = "Titulo cant be blank")
    private String titulo;

    @NotBlank(message = "Descripcion cant be blank")
    private String descripcion;

    /*@NotNull(message = "prioridad cant be blank")
    private TicketPrioridad prioridad;*/

    @NotNull(message = "categoria cant be blank")
    private Categoria categoria;

    @NotNull(message = "User cant be blank")
    private User user;
}
