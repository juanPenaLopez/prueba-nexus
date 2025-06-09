package com.example.nexus.prueba.services.impl;

import com.example.nexus.prueba.dto.UsuarioDTO;
import com.example.nexus.prueba.entities.Usuario;
import com.example.nexus.prueba.mappers.UsuarioMapper;
import com.example.nexus.prueba.repositories.UsuarioRepository;
import com.example.nexus.prueba.services.UsuarioService;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger logger = ESAPI.getLogger(UsuarioServiceImpl.class.getName());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo crearUsuario");

        if(usuarioDTO.getUsuario() == null || usuarioDTO.getUsuario().isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacio");
        }

        Optional<Usuario> usuarioExiste = usuarioRepository.findUsuarioByUsuario(usuarioDTO.getUsuario());

        if(usuarioExiste.isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe");
        }

        usuarioRepository.save(UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDTO));
        logger.debug(Logger.EVENT_SUCCESS, "Finaliza metodo crearUsuario");
    }

    @Override
    public List<UsuarioDTO> consultarUsuarios() {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo consultarUsuarios");
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO)
                .collect(Collectors.toList());
    }
}
