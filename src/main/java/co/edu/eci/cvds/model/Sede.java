package co.edu.eci.cvds.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SEDE")
public class Sede {
    @Id
    @Column(name = "NUM_SEDE")
    private int numSede;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "CIUDAD")
    private String ciudad;
    
    @Column(name = "DIRECCION")
    private String direccion;
}
