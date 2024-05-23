package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Cotizacion;
import co.edu.eci.cvds.repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionService {

    private final CotizacionRepository cotizacionRepository;

    @Autowired
    public CotizacionService(CotizacionRepository cotizacionRepository) {
        this.cotizacionRepository = cotizacionRepository;
    }

    public List<Cotizacion> getAllCotizaciones() {
        return cotizacionRepository.findAll();
    }

    public Cotizacion getCotizacionByNoCotizacion(int noCotizacion) {
        return cotizacionRepository.findByNoCotizacion(noCotizacion);
    }

    public Cotizacion createCotizacion(Cotizacion cotizacion) {
        return cotizacionRepository.save(cotizacion);
    }

    public void deleteCotizacion(int noCotizacion) {
        cotizacionRepository.deleteById(noCotizacion);
    }

    public Cotizacion updateCotizacion(int noCotizacion, Cotizacion cotizacion) {
        // Implementa la lógica de actualización según tus requerimientos
        return null;
    }
}
