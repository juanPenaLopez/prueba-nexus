package com.example.nexus.prueba.controllers;

import com.example.nexus.prueba.dto.*;
import com.example.nexus.prueba.services.MercanciaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MercanciaController.class)
public class MercanciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MercanciaService mercanciaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearMercancia() throws Exception {
        MercanciaDTO dto = new MercanciaDTO();
        // Setea campos necesarios en dto

        mockMvc.perform(post("/api/mercancia/crear-mercancia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.mensaje").value("Mercancía creada correctamente"));

        Mockito.verify(mercanciaService).crearMercancia(any(MercanciaDTO.class));
    }

    @Test
    void testEditarMercancia() throws Exception {
        MercanciaDTO dto = new MercanciaDTO();
        dto.setId(1L);
        dto.setCantidad(12);
        dto.setFechacreacion(LocalDateTime.now());
        dto.setUsuarioCreacion(new UsuarioDTO(1L, "juan", "juapena",
                new CargoDTO(1L, "Ejemplo", Boolean.TRUE), true));
        dto.setNombreProducto("ABCD");

        mockMvc.perform(put("/api/mercancia/editar-mercancia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.mensaje").value("Mercancía editada correctamente"));

        Mockito.verify(mercanciaService).editarMercancia(any(MercanciaDTO.class));
    }

    @Test
    void testEliminarMercancia() throws Exception {
        EliminarMercanciaInDTO dto = new EliminarMercanciaInDTO();
        dto.setIdMercancia(1L);
        dto.setUsuario(new UsuarioDTO(1L, "juan", "juapena",
                new CargoDTO(1L, "Ejemplo", Boolean.TRUE), true));

        mockMvc.perform(delete("/api/mercancia/eliminar-mercancia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.mensaje").value("Mercancía eliminada correctamente"));

        Mockito.verify(mercanciaService).eliminarMercancia(any(EliminarMercanciaInDTO.class));
    }

    @Test
    void testConsultarMercancias() throws Exception {
        MercanciaDTO dto1 = new MercanciaDTO();
        MercanciaDTO dto2 = new MercanciaDTO();

        dto1.setId(1L);
        dto2.setId(2L);

        Mockito.when(mercanciaService.consultarMercancias()).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/mercancia/consultar-mercancias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testConsultarMercanciasDinamica() throws Exception {
        MercanciaDTO dto = new MercanciaDTO();
        dto.setId(1L);
        dto.setCantidad(12);

        Mockito.when(mercanciaService.consultarMercanciasDinamica(any(ConsultarMercanciasInDTO.class)))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/api/mercancia/consultar-mercancias-dinamica")
                        .param("id", "1L")
                        .param("cantidad", "12")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
