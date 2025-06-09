package com.example.nexus.prueba.mappers;

import com.example.nexus.prueba.dto.MercanciaDTO;
import com.example.nexus.prueba.entities.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MercanciaMapper {

    MercanciaMapper INSTANCE = Mappers.getMapper(MercanciaMapper.class);

    MercanciaDTO mercanciaToMercanciaDTO(Mercancia mercancia);
    Mercancia mercanciaDTOToMercancia(MercanciaDTO mercanciaDTO);

}
