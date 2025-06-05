package com.davidJA.spring_boot_microservice_productos.service;

import com.davidJA.spring_boot_microservice_productos.model.producto;

import java.util.List;

public interface ProductoService {

    producto savePorducto(producto producto);

    void deletePorducto(Long id);

    List<producto> findAllPorducto();
}
