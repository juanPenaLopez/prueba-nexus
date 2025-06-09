package com.example.nexus.prueba.controllers;

import com.example.nexus.prueba.dto.CargoDTO;
import com.example.nexus.prueba.services.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private CargoService cargoService;

    @Operation(summary = "Crea un nuevo cargo")
    @PostMapping("/crear")
    public ResponseEntity<String> crearCargo(@RequestBody CargoDTO cargoDTO) {
        cargoService.crearCargo(cargoDTO);
        return new ResponseEntity<>("ok", new HttpHeaders(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene todos los cargos")
    @GetMapping("/consultar-cargos")
    public ResponseEntity<List<CargoDTO>> consultarCargos() {
        return new ResponseEntity<>(cargoService.consultarCargos(), new HttpHeaders(), HttpStatus.OK );
    }
}
