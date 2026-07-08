package com.shopeasy.tienda.repository;

import com.shopeasy.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}