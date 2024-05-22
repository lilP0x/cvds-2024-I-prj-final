package co.edu.eci.cvds.repository;


import co.edu.eci.cvds.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
      public List<Product> findByNombre(String nombre);
      public List<Product> findByCategoria(String categoria);

}

