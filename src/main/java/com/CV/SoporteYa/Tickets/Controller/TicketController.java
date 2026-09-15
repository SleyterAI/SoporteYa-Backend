package com.CV.SoporteYa.Tickets.Controller;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Ticket;
import com.CV.SoporteYa.Tickets.Enums.TicketEstado;
import com.CV.SoporteYa.Tickets.Enums.TicketPrioridad;
import com.CV.SoporteYa.Tickets.Services.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ticketService.createTicket(ticketRequest));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTicket(
            @RequestParam(required = false) TicketEstado estado,
            @RequestParam(required = false) TicketPrioridad prioridad) {
        return ResponseEntity.ok(ticketService.getTicketsByEstadoNRPrioridad(estado, prioridad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<String> updateTicketStatus(@PathVariable Long id, @RequestBody Ticket newStatus) {
        Ticket ticket = ticketService.updateTicketByStatus(id, newStatus.getEstado());
        return ResponseEntity.ok("Product Id: "+ticket.getId()+", visible now is: "+ticket.getEstado());
    }
}
