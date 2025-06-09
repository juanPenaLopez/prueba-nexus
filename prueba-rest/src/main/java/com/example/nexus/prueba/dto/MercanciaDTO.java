package com.example.nexus.prueba.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MercanciaDTO {

    private Long id;
    private String nombreProducto;
    private Integer cantidad;
    private LocalDate fechaIngreso;
    private UsuarioDTO usuarioCreacion;
    private LocalDateTime fechacreacion;
    private UsuarioDTO usuarioModificacion;
    private LocalDateTime fechaModificacion;
}
