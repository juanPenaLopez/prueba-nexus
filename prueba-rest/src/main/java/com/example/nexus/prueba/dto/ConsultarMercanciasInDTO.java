package com.example.nexus.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ConsultarMercanciasInDTO {

    private LocalDate fecha;
    private String usuario;
}
