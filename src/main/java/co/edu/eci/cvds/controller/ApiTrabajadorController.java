package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Trabajador;
import co.edu.eci.cvds.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class ApiTrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> getAllTrabajadores() {
        return trabajadorService.getAllTrabajadores();
    }

    @GetMapping("/searchByName/{name}")
    public List<Trabajador> searchTrabajadoresByName(@PathVariable String name) {
        return trabajadorService.getTrabajadoresByName(name);
    }

    @GetMapping("/{id}")
    public Trabajador getTrabajadorById(@PathVariable String id) {
        return trabajadorService.getTrabajadorById(id);
    }

    @PostMapping
    public Trabajador createTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.createTrabajador(trabajador);
    }

    @DeleteMapping("/{id}")
    public void deleteTrabajador(@PathVariable String id) {
        trabajadorService.deleteTrabajador(id);
    }

    @PutMapping("/{id}")
    public Trabajador updateTrabajador(@PathVariable String id, @RequestBody Trabajador trabajador) {
        return trabajadorService.updateTrabajador(id, trabajador);
    }
}
