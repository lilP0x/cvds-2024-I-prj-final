package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
    List<Proveedor> findByNombre(String nombre);
}
