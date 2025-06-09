package com.example.nexus.prueba.services;

import com.example.nexus.prueba.dto.CargoDTO;

import java.util.List;

public interface CargoService {
    void crearCargo(CargoDTO cargoDTO);
    List<CargoDTO> consultarCargos();
}
