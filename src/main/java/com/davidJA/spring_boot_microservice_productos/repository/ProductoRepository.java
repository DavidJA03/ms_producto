package com.davidJA.spring_boot_microservice_productos.repository;


import com.davidJA.spring_boot_microservice_productos.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<producto, Long> {
}
