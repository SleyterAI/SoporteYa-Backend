package com.CV.SoporteYa.Tickets.Services;

import com.CV.SoporteYa.Tickets.Dto.Categoria.CategoriaResponse;
import com.CV.SoporteYa.Tickets.Dto.TicketResponse;
import com.CV.SoporteYa.Tickets.Entity.Categoria;
import com.CV.SoporteYa.Tickets.Repository.CategoriaRepository;
import com.CV.SoporteYa.Tickets.Services.Interface.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaResponse> getAllCategoria() {
        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias.stream()
                .map(categoria -> CategoriaResponse.builder()
                        .id(categoria.getId())
                        .name(categoria.getName())
                        .build()
                )
                .toList();
    }
}
