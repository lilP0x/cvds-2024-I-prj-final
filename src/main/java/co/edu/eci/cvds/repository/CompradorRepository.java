package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, String> {
    List<Comprador> findByNombre(String nombre);
}
