package com.example.nexus.prueba.mappers;

import com.example.nexus.prueba.dto.CargoDTO;
import com.example.nexus.prueba.entities.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CargoMapper {

    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoDTO cargoToCargoDTO(Cargo cargo);
    Cargo cargoDTOToCargo(CargoDTO cargo);
    List<CargoDTO> cargoListToCargoDTOList(List<Cargo> cargoList);
}
