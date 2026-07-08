package com.shopeasy.tienda.service;

import com.shopeasy.tienda.domain.Producto;
import com.shopeasy.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void guardar(Producto producto) {
        repo.save(producto);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<Producto> buscarPorNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            return repo.findAll();
        }

        return repo.findByNombreContainingIgnoreCase(nombre);

    }

}