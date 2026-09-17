package com.CV.SoporteYa.Tickets.Services.Interface;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;

import java.util.List;

public interface ITicketService {
    //create
    TicketResponse createTicket(TicketRequest ticketRequest);

    //read
    List<TicketResponse> getAllTicket();
    List<TicketResponse> getTicketsByEstadoNRPrioridad(TicketEstado estado, TicketPrioridad prioridad);
    TicketResponse getTicketById(Long id);

    //update
    Ticket updateTicketByStatus(Long id, TicketEstado newEstado);

    //delete
    TicketMessageResponse deleteTicket(Ticket ticket);
}
