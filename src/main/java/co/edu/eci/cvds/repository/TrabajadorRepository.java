package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, String> {
    List<Trabajador> findByNombre(String nombre);
}
