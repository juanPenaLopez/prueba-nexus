package com.example.nexus.prueba.mappers;

import com.example.nexus.prueba.dto.UsuarioDTO;
import com.example.nexus.prueba.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}
