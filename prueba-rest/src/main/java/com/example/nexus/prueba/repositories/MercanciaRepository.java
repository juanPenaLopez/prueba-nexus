package com.example.nexus.prueba.repositories;

import com.example.nexus.prueba.entities.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long> {

    Optional<Mercancia> findMercanciaByNombreProducto(String nombreProducto);
    List<Mercancia> findMercanciasByFechaIngresoAndUsuarioCreacion_Usuario(LocalDate fecha, String usuario);
    List<Mercancia> findMercanciasByUsuarioCreacion_Usuario(String usuario);
    List<Mercancia> findMercanciasByFechaIngreso(LocalDate fecha);
}
