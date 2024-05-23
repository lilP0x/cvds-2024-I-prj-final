package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Trabajador;
import co.edu.eci.cvds.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    @Autowired
    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<Trabajador> getTrabajadoresByName(String name) {
        return trabajadorRepository.findByNombre(name);
    }

    public Trabajador createTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador addTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador getTrabajador(String name) {
        return trabajadorRepository.findByNombre(name).get(0);
    }

    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador getTrabajadorById(String id) {
        Optional<Trabajador> trabajadorOptional = trabajadorRepository.findById(id);
        return trabajadorOptional.orElse(null);
    }

    public void deleteTrabajador(String id) {
        trabajadorRepository.deleteById(id);
    }

    public Trabajador updateTrabajador(String id, Trabajador trabajador) {
        Optional<Trabajador> existingTrabajadorOpt = trabajadorRepository.findById(id);

        if (existingTrabajadorOpt.isPresent()) {
            Trabajador existingTrabajador = existingTrabajadorOpt.get();

            existingTrabajador.setNombre(trabajador.getNombre());
            existingTrabajador.setTipoId(trabajador.getTipoId());
            existingTrabajador.setNumeroId(trabajador.getNumeroId());
            existingTrabajador.setCorreo(trabajador.getCorreo());
            existingTrabajador.setDireccion(trabajador.getDireccion());
            existingTrabajador.setCargo(trabajador.getCargo());
            existingTrabajador.setNumeroContrato(trabajador.getNumeroContrato());
            existingTrabajador.setAcuerdos(trabajador.getAcuerdos());

            return trabajadorRepository.save(existingTrabajador);
        } else {
            throw new RuntimeException("Trabajador with ID " + id + " not found");
        }
    }
}
