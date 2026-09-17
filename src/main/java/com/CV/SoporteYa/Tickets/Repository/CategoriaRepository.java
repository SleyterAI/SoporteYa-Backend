package com.CV.SoporteYa.Tickets.Repository;

import com.CV.SoporteYa.Tickets.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
