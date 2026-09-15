package com.CV.SoporteYa.Tickets.Enums;

public enum TicketEstado {
    ABIERTO,
    EN_PROGRESO,
    RESUELTO,
    CERRADO;

    public boolean validateWorkflow(TicketEstado nuevoEstado) {

        return switch (this) {
            case ABIERTO -> nuevoEstado == EN_PROGRESO;
            case EN_PROGRESO -> nuevoEstado == RESUELTO;
            case RESUELTO -> nuevoEstado == CERRADO || nuevoEstado == EN_PROGRESO;
            case CERRADO -> false;
        };
    }
}
