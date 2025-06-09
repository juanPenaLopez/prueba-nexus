package com.example.nexus.prueba.controllers;

import com.example.nexus.prueba.dto.ConsultarMercanciasInDTO;
import com.example.nexus.prueba.dto.EliminarMercanciaInDTO;
import com.example.nexus.prueba.dto.MercanciaDTO;
import com.example.nexus.prueba.services.MercanciaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mercancia")
@CrossOrigin(origins = "http://localhost:4200")
public class MercanciaController {

    private MercanciaService mercanciaService;

    @Operation(summary = "Crea una nueva mercancia")
    @PostMapping("/crear-mercancia")
    public ResponseEntity<Map<String, String>> crearMercancia(@RequestBody MercanciaDTO mercanciaDTO) {
        mercanciaService.crearMercancia(mercanciaDTO);
        return ResponseEntity.ok(Map.of("status", "ok", "mensaje", "Mercancía creada correctamente"));
    }

    @Operation(summary = "Edita una mercancia ya existente")
    @PutMapping("/editar-mercancia")
    public ResponseEntity<Map<String, String>> editarMercancia(@RequestBody MercanciaDTO mercanciaDTO) {
        mercanciaService.editarMercancia(mercanciaDTO);
        return ResponseEntity.ok(Map.of("status", "ok", "mensaje", "Mercancía editada correctamente"));
    }

    @Operation(summary = "Elimina una mercancia")
    @DeleteMapping("/eliminar-mercancia")
    public ResponseEntity<Map<String, String>> eliminarMercancia(@RequestBody EliminarMercanciaInDTO eliminarMercanciaInDTO) {
        mercanciaService.eliminarMercancia(eliminarMercanciaInDTO);
        return ResponseEntity.ok(Map.of("status", "ok", "mensaje", "Mercancía eliminada correctamente"));
    }

    @Operation(summary = "Lista todas las mercancias existentes")
    @GetMapping("/consultar-mercancias")
    public ResponseEntity<List<MercanciaDTO>> consultarMercancias() {
        return new ResponseEntity<>(mercanciaService.consultarMercancias(), new HttpHeaders(), HttpStatus.OK );
    }

    @Operation(summary = "Lista todas las mercancias existentes segun los filtros")
    @GetMapping("/consultar-mercancias-dinamica")
    public ResponseEntity<List<MercanciaDTO>> consultarMercanciasDinamica(@ModelAttribute ConsultarMercanciasInDTO consultarMercanciasInDTO) {
        return new ResponseEntity<>(mercanciaService.consultarMercanciasDinamica(consultarMercanciasInDTO), new HttpHeaders(), HttpStatus.OK );
    }
}
