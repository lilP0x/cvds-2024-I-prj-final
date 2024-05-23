package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.CentroAutomotriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroAutomotrizRepository extends JpaRepository<CentroAutomotriz, String> {
    
}
