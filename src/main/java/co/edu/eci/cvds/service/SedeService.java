package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Sede;
import co.edu.eci.cvds.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    private final SedeRepository sedeRepository;

    @Autowired
    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    public Sede getSedeById(int numSede) {
        return sedeRepository.findById(numSede).orElse(null);
    }

    public Sede createSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public void deleteSede(int numSede) {
        sedeRepository.deleteById(numSede);
    }
}
