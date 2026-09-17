package com.CV.SoporteYa.Tickets.Services.Interface;

import com.CV.SoporteYa.Tickets.Dto.Categoria.CategoriaResponse;
import com.CV.SoporteYa.Tickets.Entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaResponse> getAllCategoria();
}
