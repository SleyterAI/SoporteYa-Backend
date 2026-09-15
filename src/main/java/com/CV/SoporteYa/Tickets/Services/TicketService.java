package com.CV.SoporteYa.Tickets.Services;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import com.CV.SoporteYa.Tickets.Repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService{

    private final TicketRepository ticketRepository;

    @Override
    public TicketMessageResponse createTicket(TicketRequest ticketRequest) {
        Ticket ticket = Ticket.builder()
                .titulo(ticketRequest.getTitulo())
                .descripcion(ticketRequest.getDescripcion())
                .prioridad(ticketRequest.getPrioridad())
                .estado("ABIERTO")
                .fechaCreacion(LocalDate.now())
                .build();
        ticketRepository.save(ticket);
        return TicketMessageResponse.builder()
                .mensaje("Ticket Creado")
                .build();
    }

    @Override
    public List<TicketResponse> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(
                ticket -> TicketResponse.builder()
                        .id(ticket.getId())
                        .titulo(ticket.getTitulo())
                        .descripcion(ticket.getDescripcion())
                        .prioridad(ticket.getPrioridad())
                        .estado(ticket.getEstado())
                        .fechaCreacion(ticket.getFechaCreacion())
                        .build()
                )
                .toList();
    }

    @Override
    public List<TicketResponse> getTicketsByEstadoNRPrioridad(String estado, String prioridad) {
        if (estado != null && prioridad != null) {
            return ticketRepository.findByEstadoAndPrioridad(estado, prioridad);
        } else if (estado != null) {
            return ticketRepository.findByEstado(estado);
        } else if (prioridad != null) {
            return ticketRepository.findByPrioridad(prioridad);
        }
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticket -> TicketResponse.builder()
                        .id(ticket.getId())
                        .titulo(ticket.getTitulo())
                        .descripcion(ticket.getDescripcion())
                        .prioridad(ticket.getPrioridad())
                        .estado(ticket.getEstado())
                        .fechaCreacion(ticket.getFechaCreacion())
                        .build()
                )
                .toList();
    }

    @Override
    public TicketResponse getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("El ticket no existe"));
        return TicketResponse.builder()
                .id(ticket.getId())
                .titulo(ticket.getTitulo())
                .descripcion(ticket.getDescripcion())
                .prioridad(ticket.getPrioridad())
                .estado(ticket.getEstado())
                .fechaCreacion(ticket.getFechaCreacion())
                .build();
    }

    @Override
    public TicketMessageResponse updateTicketByStatus(Long id, TicketRequest ticketRequest) {
        Ticket updateTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El ticket no existe"));

        updateTicket.setTitulo(ticketRequest.getTitulo());
        updateTicket.setDescripcion(ticketRequest.getDescripcion());
        updateTicket.setPrioridad(ticketRequest.getPrioridad());
        updateTicket.setEstado(ticketRequest.getEstado());
        updateTicket.setFechaCreacion(ticketRequest.getFechaCreacion());
        ticketRepository.save(updateTicket);

        return TicketMessageResponse.builder()
                .mensaje("Ticket actualizado")
                .build();
    }

    @Override
    public TicketMessageResponse deleteTicket(Ticket ticket) {
        return null;
    }
}
