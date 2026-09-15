package com.CV.SoporteYa.Tickets.Dto;

import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TicketRequest {
    @NotBlank(message = "Titulo cant be blank")
    private String titulo;

    @NotBlank(message = "Descripcion cant be blank")
    private String descripcion;

    @NotNull(message = "prioridad cant be blank")
    private TicketPrioridad prioridad;
}
