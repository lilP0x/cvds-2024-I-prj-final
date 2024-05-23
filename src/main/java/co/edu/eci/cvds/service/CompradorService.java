package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Comprador;
import co.edu.eci.cvds.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorService {

    private final CompradorRepository compradorRepository;

    @Autowired
    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    public List<Comprador> getCompradoresByName(String name) {
        return compradorRepository.findByNombre(name);
    }

    public Comprador createComprador(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    public Comprador addComprador(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    public Comprador getComprador(String name) {
        return compradorRepository.findByNombre(name).get(0);
    }

    public List<Comprador> getAllCompradores() {
        return compradorRepository.findAll();
    }

    public Comprador getCompradorById(String id) {
        Optional<Comprador> compradorOptional = compradorRepository.findById(id);
        return compradorOptional.orElse(null);
    }

    public void deleteComprador(String id) {
        compradorRepository.deleteById(id);
    }

    public Comprador updateComprador(String id, Comprador comprador) {
        Optional<Comprador> existingCompradorOpt = compradorRepository.findById(id);

        if (existingCompradorOpt.isPresent()) {
            Comprador existingComprador = existingCompradorOpt.get();

            existingComprador.setNombre(comprador.getNombre());
            existingComprador.setTipoId(comprador.getTipoId());
            existingComprador.setNumeroId(comprador.getNumeroId());
            existingComprador.setCorreo(comprador.getCorreo());
            existingComprador.setDireccion(comprador.getDireccion());
            existingComprador.setEspecificaciones(comprador.getEspecificaciones());
            existingComprador.setTipo(comprador.getTipo());
            existingComprador.setModoDePago(comprador.getModoDePago());

            return compradorRepository.save(existingComprador);
        } else {
            throw new RuntimeException("Comprador with ID " + id + " not found");
        }
    }
}
