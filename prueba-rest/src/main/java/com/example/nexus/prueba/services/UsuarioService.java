package com.example.nexus.prueba.services;

import com.example.nexus.prueba.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    void crearUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> consultarUsuarios();
}
