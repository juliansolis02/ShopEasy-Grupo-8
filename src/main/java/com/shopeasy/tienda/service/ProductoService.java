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

    public List<Producto> buscarCatalogo(String nombre, Long categoriaId) {
        boolean nombreVacio = nombre == null || nombre.isBlank();
        boolean categoriaVacia = categoriaId == null;

        if (nombreVacio && categoriaVacia) {
            return repo.findAll();
        }

        if (!nombreVacio && !categoriaVacia) {
            return repo.findByNombreContainingIgnoreCaseAndCategoriaId(nombre, categoriaId);
        }

        if (!nombreVacio) {
            return repo.findByNombreContainingIgnoreCase(nombre);
        }

        return repo.findByCategoriaId(categoriaId);
    }
}