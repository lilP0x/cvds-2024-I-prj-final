package co.edu.eci.cvds.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "COTIZACION")
public class Cotizacion {
    @Id
    @Column(name = "NO_COTIZACION")
    private int noCotizacion;
    
    @Column(name = "IMPUESTO")
    private int impuesto;
    
    // Constructor, getters y setters
}
