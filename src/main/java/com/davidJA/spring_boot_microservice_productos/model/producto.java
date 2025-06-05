package com.davidJA.spring_boot_microservice_productos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 150, nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Long stock;


     @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;
}
