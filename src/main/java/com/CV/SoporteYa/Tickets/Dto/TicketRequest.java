package com.CV.SoporteYa.Tickets.Dto;

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

    @NotBlank(message = "prioridad cant be blank")
    private String prioridad;

    @NotBlank(message = "prioridad cant be blank")
    private String estado;

    @NotNull
    private LocalDate fechaCreacion;
}
