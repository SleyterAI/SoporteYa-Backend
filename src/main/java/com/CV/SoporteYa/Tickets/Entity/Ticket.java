package com.CV.SoporteYa.Tickets.Entity;

import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketPrioridad prioridad;
    //ALTA - MEDIA - BAJA

    @Enumerated(EnumType.STRING)
    private TicketEstado estado;
    //ABIERTO - EN_PROGRESO - RESUELTO - CERRADO

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
}
