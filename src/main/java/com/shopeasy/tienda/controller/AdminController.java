package com.shopeasy.tienda.controller;

import com.shopeasy.tienda.domain.Producto;
import com.shopeasy.tienda.service.CategoriaService;
import com.shopeasy.tienda.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public AdminController(ProductoService productoService,
                           CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/admin")
    public String dashboard(Model model) {

        int totalProductos = productoService.listar().size();
        int totalCategorias = categoriaService.listar().size();

        long stockBajo = productoService.listar()
                .stream()
                .filter(p -> p.getStock() <= 5)
                .count();

        model.addAttribute("totalProductos", totalProductos);
        model.addAttribute("totalCategorias", totalCategorias);
        model.addAttribute("stockBajo", stockBajo);

        return "admin/dashboard";
    }
}
