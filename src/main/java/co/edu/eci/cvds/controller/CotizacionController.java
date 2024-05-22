package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Cotizacion;
import co.edu.eci.cvds.service.CotizacionService;

import java.util.List;

@Controller
@RequestMapping("/cotizaciones")
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @GetMapping("/cotizaciones")
    public String showCotizacionesPage(Model model) {
        List<Cotizacion> cotizaciones = cotizacionService.getAllCotizaciones();
        model.addAttribute("cotizaciones", cotizaciones);
        return "cotizaciones";
    }

    @GetMapping("/{noCotizacion}")
    public String showCotizacion(@PathVariable int noCotizacion, Model model) {
        return "cotizacion";
    }

    @GetMapping("/nueva")
    public String showNuevaCotizacionPage() {
        return "nuevaCotizacion";
    }
}
