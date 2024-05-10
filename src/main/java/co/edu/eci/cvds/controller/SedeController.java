package co.edu.eci.cvds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.eci.cvds.model.Sede;
import co.edu.eci.cvds.service.SedeService;

import java.util.List;

@Controller
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/sedes")
    public String showSedesPage(Model model) {
        List<Sede> sedes = sedeService.getAllSedes();
        model.addAttribute("sedes", sedes);
        return "sedes";
    }

    @GetMapping("/{numSede}")
    public String showSede(@PathVariable int numSede, Model model) {
        return "sede";
    }

    @GetMapping("/nueva")
    public String showNuevaSedePage() {
        return "nuevaSede";
    }
}
