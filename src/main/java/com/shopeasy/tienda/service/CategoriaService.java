package com.shopeasy.tienda.service;

import com.shopeasy.tienda.domain.Categoria;
import com.shopeasy.tienda.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public void guardar(Categoria categoria) {
        repo.save(categoria);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Categoria buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

}