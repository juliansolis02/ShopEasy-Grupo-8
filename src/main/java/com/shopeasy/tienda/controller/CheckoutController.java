package com.shopeasy.tienda.controller;

import com.shopeasy.tienda.domain.CarritoItem;
import com.shopeasy.tienda.domain.Compra;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @GetMapping
    public String mostrarCheckout(HttpSession session, Model model) {
        List<CarritoItem> carrito = obtenerCarrito(session);

        if (carrito.isEmpty()) {
            return "redirect:/carrito";
        }

        double total = carrito.stream()
                .mapToDouble(CarritoItem::getSubtotal)
                .sum();

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "checkout/formulario";
    }

    @PostMapping("/confirmar")
    public String confirmarCompra(HttpSession session, Model model) {
        List<CarritoItem> carrito = obtenerCarrito(session);

        double total = carrito.stream()
                .mapToDouble(CarritoItem::getSubtotal)
                .sum();

        List<Compra> historial = obtenerHistorial(session);

        Compra compra = new Compra(
                historial.size() + 1,
                LocalDateTime.now(),
                total,
                "Confirmado",
                new ArrayList<>(carrito)
        );

        historial.add(compra);

        session.setAttribute("historial", historial);
        session.removeAttribute("carrito");

        model.addAttribute("total", total);

        return "checkout/confirmacion";
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

    @SuppressWarnings("unchecked")
    private List<Compra> obtenerHistorial(HttpSession session) {
        List<Compra> historial =
                (List<Compra>) session.getAttribute("historial");

        if (historial == null) {
            historial = new ArrayList<>();
            session.setAttribute("historial", historial);
        }

        return historial;
    }
}