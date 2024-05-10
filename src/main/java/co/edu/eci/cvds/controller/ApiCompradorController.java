package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Comprador;
import co.edu.eci.cvds.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compradores")
public class ApiCompradorController {

    @Autowired
    private CompradorService compradorService;

    @GetMapping
    public List<Comprador> getAllCompradores() {
        return compradorService.getAllCompradores();
    }

    @GetMapping("/searchByName/{name}")
    public List<Comprador> searchCompradoresByName(@PathVariable String name) {
        return compradorService.getCompradoresByName(name);
    }

    @GetMapping("/{id}")
    public Comprador getCompradorById(@PathVariable String id) {
        return compradorService.getCompradorById(id);
    }

    @PostMapping
    public Comprador createComprador(@RequestBody Comprador comprador) {
        return compradorService.createComprador(comprador);
    }

    @DeleteMapping("/{id}")
    public void deleteComprador(@PathVariable String id) {
        compradorService.deleteComprador(id);
    }

    @PutMapping("/{id}")
    public Comprador updateComprador(@PathVariable String id, @RequestBody Comprador comprador) {
        return compradorService.updateComprador(id, comprador);
    }
}
