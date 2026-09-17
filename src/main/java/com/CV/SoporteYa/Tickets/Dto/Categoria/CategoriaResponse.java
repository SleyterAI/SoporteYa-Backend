package com.CV.SoporteYa.Tickets.Dto.Categoria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoriaResponse {
    private Long id;
    private String name;
}
