package com.CV.SoporteYa.Tickets.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

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
    private String prioridad;
    //ALTA - MEDIA - BAJA

    @Column(nullable = false)
    private String estado;
    //ABIERTO - EN_PROGRESO - RESUELTO - CERRADO

    @Column(nullable = false)
    private LocalDate fechaCreacion;
}
