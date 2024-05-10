package co.edu.eci.cvds.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.eci.cvds.model.Proveedor;
import co.edu.eci.cvds.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ApiProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/searchByName/{name}")
    public List<Proveedor> searchProveedoresByName(@PathVariable String name) {
        return proveedorService.getProveedoresByName(name);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable String id) {
        return proveedorService.getProveedorById(id);
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.createProveedor(proveedor);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable String id) {
        proveedorService.deleteProveedor(id);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable String id, @RequestBody Proveedor proveedor) {
        return proveedorService.updateProveedor(id, proveedor);
    }
}
