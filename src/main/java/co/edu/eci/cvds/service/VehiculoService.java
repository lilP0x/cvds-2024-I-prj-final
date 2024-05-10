package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Vehiculo;
import co.edu.eci.cvds.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> getVehiculosByMarca(String marca) {
        return vehiculoRepository.findByMarca(marca);
    }

    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo getVehiculo(String marca) {
        return vehiculoRepository.findByMarca(marca).get(0);
    }

    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculoById(String id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        return vehiculoOptional.orElse(null);
    }

    public void deleteVehiculo(String id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo updateVehiculo(String id, Vehiculo vehiculo) {
        Optional<Vehiculo> existingVehiculoOpt = vehiculoRepository.findById(id);

        if (existingVehiculoOpt.isPresent()) {
            Vehiculo existingVehiculo = existingVehiculoOpt.get();

            existingVehiculo.setMarca(vehiculo.getMarca());
            existingVehiculo.setPlaca(vehiculo.getPlaca());
            existingVehiculo.setAño(vehiculo.getAño());
            existingVehiculo.setFecha(vehiculo.getFecha());
            existingVehiculo.setCiudad(vehiculo.getCiudad());
            existingVehiculo.setCilindraje(vehiculo.getCilindraje());

            return vehiculoRepository.save(existingVehiculo);
        } else {
            throw new RuntimeException("Vehiculo with ID " + id + " not found");
        }
    }
}
