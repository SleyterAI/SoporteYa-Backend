package com.CV.SoporteYa.Tickets.Services;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import com.CV.SoporteYa.Tickets.Mapper.ResponseMapper;
import com.CV.SoporteYa.Tickets.Repository.TicketRepository;
import com.CV.SoporteYa.Tickets.Services.Interface.ITicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;
    private final ResponseMapper responseMapper;

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
            Ticket ticket = Ticket.builder()
                    .titulo(ticketRequest.getTitulo())
                    .descripcion(ticketRequest.getDescripcion())
                    .prioridad(ticketRequest.getPrioridad())
                    .categoria(ticketRequest.getCategoria())
                    .estado(TicketEstado.ABIERTO)
                    .fechaCreacion(LocalDateTime.now())
                    .user(ticketRequest.getUser())
                    .build();
            Ticket ticket2 = ticketRepository.save(ticket);

            return responseMapper.toResponse(ticket2);
    }

    @Override
    public List<TicketResponse> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticket -> TicketResponse.builder()
                        .id(ticket.getId())
                        .titulo(ticket.getTitulo())
                        .descripcion(ticket.getDescripcion())
                        .prioridad(ticket.getPrioridad())
                        .estado(ticket.getEstado())
                        .categoria_name(ticket.getCategoria().getName())
                        .fechaCreacion(ticket.getFechaCreacion())
                        .user_fullname(ticket.getUser().getFullname())
                        .build()
                )
                .toList();
    }

    @Override
    public List<TicketResponse> getTicketsByEstadoNRPrioridad(TicketEstado estado, TicketPrioridad prioridad) {
        if (estado != null && prioridad != null) {
            return ticketRepository.findByEstadoAndPrioridad(estado, prioridad);
        } else if (estado != null) {
            return ticketRepository.findByEstado(estado);
        } else if (prioridad != null) {
            return ticketRepository.findByPrioridad(prioridad);
        }

        return getAllTicket();
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
                .categoria_name(ticket.getCategoria().getName())
                .fechaCreacion(ticket.getFechaCreacion())
                .user_fullname(ticket.getUser().getFullname())
                .build();
    }

    @Override
    public Ticket updateTicketByStatus(Long id, TicketEstado newEstado) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El ticket no existe"));

        if (!ticket.getEstado().validateWorkflow(newEstado)) {
            throw new RuntimeException(
                    "No se puede cambiar de " + ticket.getEstado() + " a " + newEstado
            );
        }
        ticket.setEstado(newEstado);
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketMessageResponse deleteTicket(Ticket ticket) {
        return null;
    }
}
