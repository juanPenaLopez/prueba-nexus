package com.example.nexus.prueba.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name="MERCANCIA")
@Data
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NonNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NonNull
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_creacion")
    private Usuario usuarioCreacion;

    @NonNull
    @Column(name="fecha_creacion")
    private LocalDateTime fechacreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_modificacion")
    private Usuario usuarioModificacion;

    @Column(name="fecha_modificacion")
    private LocalDateTime fechaModificacion;
}
