package com.example.nexus.prueba.controllers;

import com.example.nexus.prueba.dto.UsuarioDTO;
import com.example.nexus.prueba.entities.Usuario;
import com.example.nexus.prueba.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping("/crear-usuario")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.crearUsuario(usuarioDTO);
        return new ResponseEntity<>("ok", new HttpHeaders(), HttpStatus.OK);
    }

    @Operation(summary = "Lista todos los usuarios existentes")
    @GetMapping("/consultar-usuarios")
    public ResponseEntity<List<UsuarioDTO>> consultarUsuarios() {
        return new ResponseEntity<>(usuarioService.consultarUsuarios(), new HttpHeaders(), HttpStatus.OK );
    }
}
