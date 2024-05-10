package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.CentroAutomotriz;
import co.edu.eci.cvds.repository.CentroAutomotrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroAutomotrizService {

    private final CentroAutomotrizRepository centroAutomotrizRepository;

    @Autowired
    public CentroAutomotrizService(CentroAutomotrizRepository centroAutomotrizRepository) {
        this.centroAutomotrizRepository = centroAutomotrizRepository;
    }

    public List<CentroAutomotriz> getAllCentrosAutomotriz() {
        return centroAutomotrizRepository.findAll();
    }

    public CentroAutomotriz getCentroAutomotrizById(String id) {
        return centroAutomotrizRepository.findById(id).orElse(null);
    }

    public CentroAutomotriz createCentroAutomotriz(CentroAutomotriz centroAutomotriz) {
        return centroAutomotrizRepository.save(centroAutomotriz);
    }

    public void deleteCentroAutomotriz(String id) {
        centroAutomotrizRepository.deleteById(id);
    }

    public CentroAutomotriz updateCentroAutomotriz(String id, CentroAutomotriz centroAutomotriz) {
        return null;
    }
}
