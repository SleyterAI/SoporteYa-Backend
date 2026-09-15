package com.CV.SoporteYa.Tickets.Services;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;

import java.util.List;

public interface ITicketService {
    //create
    TicketMessageResponse createTicket(TicketRequest ticketRequest);

    //read
    List<TicketResponse> getAllTicket();
    List<TicketResponse> getTicketsByEstadoNRPrioridad(String estado, String prioridad);
    TicketResponse getTicketById(Long id);

    //update
    TicketMessageResponse updateTicketByStatus(Long id, TicketRequest ticketRequest);

    //delete
    TicketMessageResponse deleteTicket(Ticket ticket);
}
