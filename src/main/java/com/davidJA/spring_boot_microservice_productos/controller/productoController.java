package com.davidJA.spring_boot_microservice_productos.controller;

import com.davidJA.spring_boot_microservice_productos.model.producto;
import com.davidJA.spring_boot_microservice_productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Indica que esta clase es un controlador REST.
//Spring convierte automáticamente los valores retornados en JSON, ideal para APIs.
@RestController

//Establece la ruta base para todas las URL del controlador.
@RequestMapping("api/producto")
public class productoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody producto producto) {
        return new ResponseEntity<>(productoService.savePorducto(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("{idProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long idProducto) {
        productoService.deletePorducto(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getProducto() {
        return new ResponseEntity<>(productoService.findAllPorducto(), HttpStatus.OK);
    }

}
