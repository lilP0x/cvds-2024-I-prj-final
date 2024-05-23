package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Vehiculo;
import co.edu.eci.cvds.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class ApiVehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }

    @GetMapping("/searchByMarca/{marca}")
    public List<Vehiculo> searchVehiculosByMarca(@PathVariable String marca) {
        return vehiculoService.getVehiculosByMarca(marca);
    }

    @GetMapping("/{id}")
    public Vehiculo getVehiculoById(@PathVariable String id) {
        return vehiculoService.getVehiculoById(id);
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.createVehiculo(vehiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable String id) {
        vehiculoService.deleteVehiculo(id);
    }

    @PutMapping("/{id}")
    public Vehiculo updateVehiculo(@PathVariable String id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.updateVehiculo(id, vehiculo);
    }
}
