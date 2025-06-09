package com.example.nexus.prueba.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {

    private Long id;
    private String nombre;
    private Boolean activo;
}
