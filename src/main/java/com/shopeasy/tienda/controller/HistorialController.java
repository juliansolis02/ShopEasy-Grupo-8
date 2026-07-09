package com.shopeasy.tienda.controller;

import com.shopeasy.tienda.domain.Compra;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistorialController {

    @GetMapping("/historial")
    public String verHistorial(HttpSession session, Model model) {

        List<Compra> historial = obtenerHistorial(session);

        model.addAttribute("historial", historial);

        return "historial/listado";
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
