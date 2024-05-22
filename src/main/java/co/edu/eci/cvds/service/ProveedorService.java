package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Proveedor;
import co.edu.eci.cvds.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> getProveedoresByName(String name) {
        return proveedorRepository.findByNombre(name);
    }

    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor getProveedor(String name) {
        List<Proveedor> proveedores = proveedorRepository.findByNombre(name);
        if (!proveedores.isEmpty()) {
            return proveedores.get(0);
        }
        return null;
    }

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    

    public Proveedor getProveedorById(String id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        return proveedorOptional.orElse(null);
    }

    public void deleteProveedor(String id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor updateProveedor(String id, Proveedor proveedor) {
        Optional<Proveedor> existingProveedorOpt = proveedorRepository.findById(id);

        if (existingProveedorOpt.isPresent()) {
            Proveedor existingProveedor = existingProveedorOpt.get();

            existingProveedor.setNombre(proveedor.getNombre());
            existingProveedor.setTipoId(proveedor.getTipoId());
            existingProveedor.setNumeroId(proveedor.getNumeroId());
            existingProveedor.setCorreo(proveedor.getCorreo());
            existingProveedor.setDireccion(proveedor.getDireccion());
            existingProveedor.setRazonSocial(proveedor.getRazonSocial());
            existingProveedor.setTipo(proveedor.getTipo());
            existingProveedor.setEspecificaciones(proveedor.getEspecificaciones());

            return proveedorRepository.save(existingProveedor);
        } else {
            throw new RuntimeException("Proveedor with ID " + id + " not found");
        }
    }
}
