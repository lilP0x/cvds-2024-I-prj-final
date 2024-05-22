package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.CentroAutomotriz;
import co.edu.eci.cvds.service.CentroAutomotrizService;

import java.util.List;

@Controller
@RequestMapping("/centros")
public class CentroAutomotrizController {

    @Autowired
    private CentroAutomotrizService centroAutomotrizService;

    @GetMapping("/centros")
    public String showCentrosPage(Model model) {
        List<CentroAutomotriz> centros = centroAutomotrizService.getAllCentrosAutomotriz();
        model.addAttribute("centros", centros);
        return "centros";
    }

    @GetMapping("/{id}")
    public String showCentro(@PathVariable String id, Model model) {
        return "centro";
    }
}
