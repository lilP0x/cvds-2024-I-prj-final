package co.edu.eci.cvds.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "CENTRO_AUTOMOTRIZ")
public class CentroAutomotriz {
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "ESPECIFICACIONES")
    private String especificaciones;
    
}
