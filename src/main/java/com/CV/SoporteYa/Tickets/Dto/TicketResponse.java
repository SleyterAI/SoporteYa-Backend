package com.CV.SoporteYa.Tickets.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TicketResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    //ALTA - MEDIA - BAJA
    private String estado;
    //ABIERTO - EN_PROGRESO - RESUELTO - CERRADO
    private LocalDate fechaCreacion;
}
