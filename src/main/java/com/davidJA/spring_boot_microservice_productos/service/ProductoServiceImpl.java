package com.davidJA.spring_boot_microservice_productos.service;

import com.davidJA.spring_boot_microservice_productos.model.producto;
import com.davidJA.spring_boot_microservice_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    public producto savePorducto(producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public void deletePorducto(Long id){
        productoRepository.deleteById(id);
    }

    @Override
    public List<producto> findAllPorducto(){
        return productoRepository.findAll();
    }

}
