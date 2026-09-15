package com.CV.SoporteYa.Tickets.Controller;

import com.CV.SoporteYa.Tickets.Dto.TicketMessageResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketRequest;
import com.CV.SoporteYa.Tickets.Services.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketMessageResponse> createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ticketService.createTicket(ticketRequest));
    }

    @GetMapping
    public ResponseEntity<List<TicketMessageResponse>> getAllTicket(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String prioridad) {
        return ResponseEntity.ok(ticketService.filterProducts(estado, prioridad));
    }
}
