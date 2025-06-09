package com.example.nexus.prueba.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String usuario;
    private CargoDTO cargo;
    private Boolean activo;
}
