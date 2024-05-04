package co.edu.eci.cvds.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Aquí 'Long' indica que la clave primaria es de tipo Long
}
