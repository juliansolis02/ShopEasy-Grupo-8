package com.shopeasy.tienda.controller;

import com.shopeasy.tienda.domain.Producto;
import com.shopeasy.tienda.service.CategoriaService;
import com.shopeasy.tienda.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        return "producto/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listar());
        return "producto/modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Producto producto,
                          BindingResult result,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listar());
            return "producto/modificar";
        }

        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.listar());
        return "producto/modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/catalogo")
    public String catalogo(@RequestParam(required = false) String nombre,
                           @RequestParam(required = false) Long categoriaId,
                           Model model) {

        model.addAttribute("productos", productoService.buscarCatalogo(nombre, categoriaId));
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("nombre", nombre);
        model.addAttribute("categoriaId", categoriaId);

        return "producto/catalogo";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Producto producto = productoService.buscarPorId(id);

        if (producto == null) {
            return "redirect:/productos/catalogo";
        }

        model.addAttribute("producto", producto);
        return "producto/detalle";
    }
}