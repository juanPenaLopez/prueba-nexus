package com.example.nexus.prueba.services;

import com.example.nexus.prueba.dto.ConsultarMercanciasInDTO;
import com.example.nexus.prueba.dto.EliminarMercanciaInDTO;
import com.example.nexus.prueba.dto.MercanciaDTO;

import java.util.List;

public interface MercanciaService {
    void crearMercancia(MercanciaDTO mercanciaDTO);
    void editarMercancia(MercanciaDTO mercanciaDTO);
    void eliminarMercancia(EliminarMercanciaInDTO mercanciaInDTO);
    List<MercanciaDTO> consultarMercancias();
    List<MercanciaDTO> consultarMercanciasDinamica(ConsultarMercanciasInDTO consultarMercanciasInDTO);
}
