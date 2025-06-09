package com.example.nexus.prueba.services.impl;

import com.example.nexus.prueba.dto.CargoDTO;
import com.example.nexus.prueba.mappers.CargoMapper;
import com.example.nexus.prueba.repositories.CargoRepository;
import com.example.nexus.prueba.services.CargoService;
import jakarta.transaction.Transactional;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    private static final Logger logger = ESAPI.getLogger(CargoServiceImpl.class.getName());

    @Autowired
    private CargoRepository repository;

    @Override
    @Transactional()
    public void crearCargo(CargoDTO cargoDTO) {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo crearCargo");
        repository.save(CargoMapper.INSTANCE.cargoDTOToCargo(cargoDTO));
        logger.debug(Logger.EVENT_SUCCESS, "Finaliza metodo crearCargo");
    }

    @Override
    @Transactional()
    public List<CargoDTO> consultarCargos() {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo consultarCargos");
        return CargoMapper.INSTANCE.cargoListToCargoDTOList(repository.findAll());
    }
}
