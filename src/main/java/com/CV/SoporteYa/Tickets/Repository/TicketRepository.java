package com.CV.SoporteYa.Tickets.Repository;

import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<TicketResponse> findByEstadoAndPrioridad(TicketEstado estado, TicketPrioridad prioridad);

    List<TicketResponse> findByEstado(TicketEstado estado);

    List<TicketResponse> findByPrioridad(TicketPrioridad prioridad);
}
