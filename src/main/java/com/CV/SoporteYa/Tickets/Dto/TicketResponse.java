package com.CV.SoporteYa.Tickets.Dto;

import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private TicketPrioridad prioridad;
    //ALTA - MEDIA - BAJA
    private TicketEstado estado;
    //ABIERTO - EN_PROGRESO - RESUELTO - CERRADO
    private LocalDateTime fechaCreacion;

    private String user_fullname;
}
