package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Carrito;
import co.edu.eci.cvds.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findById(Long id);
}
