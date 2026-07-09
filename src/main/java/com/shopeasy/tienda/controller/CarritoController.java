package com.shopeasy.tienda.controller;

import com.shopeasy.tienda.domain.CarritoItem;
import com.shopeasy.tienda.domain.Producto;
import com.shopeasy.tienda.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    private final ProductoService productoService;

    public CarritoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String verCarrito(HttpSession session, Model model) {

        List<CarritoItem> carrito = obtenerCarrito(session);

        double total = carrito.stream()
                .mapToDouble(CarritoItem::getSubtotal)
                .sum();

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "carrito/listado";
    }

    @GetMapping("/agregar/{id}")
    public String agregar(@PathVariable Long id,
                          HttpSession session) {

        Producto producto = productoService.buscarPorId(id);

        if (producto == null) {
            return "redirect:/productos/catalogo";
        }

        List<CarritoItem> carrito = obtenerCarrito(session);

        boolean encontrado = false;

        for (CarritoItem item : carrito) {

            if (item.getProducto().getId().equals(id)) {

                item.setCantidad(item.getCantidad() + 1);

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {
            carrito.add(new CarritoItem(producto, 1));
        }

        session.setAttribute("carrito", carrito);

        return "redirect:/carrito";
    }

    @GetMapping("/aumentar/{id}")
    public String aumentar(@PathVariable Long id,
                           HttpSession session) {

        List<CarritoItem> carrito = obtenerCarrito(session);

        for (CarritoItem item : carrito) {

            if (item.getProducto().getId().equals(id)) {

                item.setCantidad(item.getCantidad() + 1);

                break;
            }
        }

        return "redirect:/carrito";
    }

    @GetMapping("/disminuir/{id}")
    public String disminuir(@PathVariable Long id,
                            HttpSession session) {

        List<CarritoItem> carrito = obtenerCarrito(session);

        carrito.removeIf(item -> {

            if (item.getProducto().getId().equals(id)) {

                item.setCantidad(item.getCantidad() - 1);

                return item.getCantidad() <= 0;
            }

            return false;
        });

        return "redirect:/carrito";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,
                           HttpSession session) {

        List<CarritoItem> carrito = obtenerCarrito(session);

        carrito.removeIf(item ->
                item.getProducto().getId().equals(id));

        return "redirect:/carrito";
    }

    @SuppressWarnings("unchecked")
    private List<CarritoItem> obtenerCarrito(HttpSession session) {

        List<CarritoItem> carrito =
                (List<CarritoItem>) session.getAttribute("carrito");

        if (carrito == null) {

            carrito = new ArrayList<>();

            session.setAttribute("carrito", carrito);
        }

        return carrito;
    }
}