package com.CV.SoporteYa.Tickets.Repository;

import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<TicketResponse> findByEstadoAndPrioridad(String estado, String prioridad);

    List<TicketResponse> findByEstado(String estado);

    List<TicketResponse> findByPrioridad(String prioridad);
}
