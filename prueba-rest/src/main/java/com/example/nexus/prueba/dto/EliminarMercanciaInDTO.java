package com.example.nexus.prueba.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EliminarMercanciaInDTO {
    private Long idMercancia;
    private UsuarioDTO usuario;
}
