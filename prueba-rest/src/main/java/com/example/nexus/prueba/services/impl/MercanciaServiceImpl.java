package com.example.nexus.prueba.services.impl;

import com.example.nexus.prueba.dto.ConsultarMercanciasInDTO;
import com.example.nexus.prueba.dto.EliminarMercanciaInDTO;
import com.example.nexus.prueba.dto.MercanciaDTO;
import com.example.nexus.prueba.entities.Mercancia;
import com.example.nexus.prueba.mappers.MercanciaMapper;
import com.example.nexus.prueba.repositories.MercanciaRepository;
import com.example.nexus.prueba.services.MercanciaService;
import lombok.AllArgsConstructor;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MercanciaServiceImpl implements MercanciaService {

    private static final Logger logger = ESAPI.getLogger(MercanciaServiceImpl.class.getName());

    private MercanciaRepository mercanciaRepository;

    @Override
    public void crearMercancia(MercanciaDTO mercanciaDTO) {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo crearMercancia");

        Optional<Mercancia> mercanciaExiste = mercanciaRepository.findMercanciaByNombreProducto(mercanciaDTO.getNombreProducto());

        if (mercanciaExiste.isPresent()) {
            throw new IllegalArgumentException("La mercancia ya existe");
        }

        mercanciaRepository.save(MercanciaMapper.INSTANCE.mercanciaDTOToMercancia(mercanciaDTO));
        logger.debug(Logger.EVENT_SUCCESS, "Finaliza metodo crearMercancia");
    }

    @Override
    public void editarMercancia(MercanciaDTO mercanciaDTO) {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo editarMercancia");
        mercanciaRepository.save(MercanciaMapper.INSTANCE.mercanciaDTOToMercancia(mercanciaDTO));
        logger.debug(Logger.EVENT_SUCCESS, "Finaliza metodo editarMercancia");
    }

    @Override
    public void eliminarMercancia(EliminarMercanciaInDTO mercanciaInDTO) {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo eliminarMercancia");

        Optional<Mercancia> mercancia = mercanciaRepository.findById(mercanciaInDTO.getIdMercancia());

        if(!mercancia.isPresent()) {
            throw new IllegalArgumentException("La mercancia no existe");
        }

        if(!(mercancia.get().getUsuarioCreacion().getId().compareTo(
                mercanciaInDTO.getUsuario().getId()) == 0)){
            throw new IllegalArgumentException("El usuario ingresado no es el dueño de la mercancia");
        }

        mercanciaRepository.delete(mercancia.get());
        logger.debug(Logger.EVENT_SUCCESS, "Finaliza metodo eliminarMercancia");
    }

    @Override
    public List<MercanciaDTO> consultarMercancias() {
        logger.debug(Logger.EVENT_SUCCESS, "Inicia metodo consultarMercancias");
        return mercanciaRepository.findAll().stream()
                .map(MercanciaMapper.INSTANCE::mercanciaToMercanciaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MercanciaDTO> consultarMercanciasDinamica(ConsultarMercanciasInDTO consultarMercanciasInDTO) {
        if (consultarMercanciasInDTO == null || (consultarMercanciasInDTO.getUsuario() == null
            && consultarMercanciasInDTO.getFecha() == null )) {
            return this.consultarMercancias();
        }

        if(consultarMercanciasInDTO.getFecha() != null && !consultarMercanciasInDTO.getUsuario().isEmpty()){
            return mercanciaRepository.findMercanciasByFechaIngresoAndUsuarioCreacion_Usuario
                            (consultarMercanciasInDTO.getFecha(), consultarMercanciasInDTO.getUsuario()).stream()
                    .map(MercanciaMapper.INSTANCE::mercanciaToMercanciaDTO)
                    .collect(Collectors.toList());
        }

        if(!consultarMercanciasInDTO.getUsuario().isEmpty()){
            return mercanciaRepository.findMercanciasByUsuarioCreacion_Usuario
                            (consultarMercanciasInDTO.getUsuario()).stream()
                    .map(MercanciaMapper.INSTANCE::mercanciaToMercanciaDTO)
                    .collect(Collectors.toList());
        }

        if(consultarMercanciasInDTO.getFecha() != null){
            return mercanciaRepository.findMercanciasByFechaIngreso(consultarMercanciasInDTO.getFecha()).stream()
                    .map(MercanciaMapper.INSTANCE::mercanciaToMercanciaDTO)
                    .collect(Collectors.toList());
        }

        return List.of();
    }
}
