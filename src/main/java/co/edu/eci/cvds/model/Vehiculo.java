package co.edu.eci.cvds.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "VEHICULO")
public class Vehiculo {
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "MARCA")
    private String marca;
    
    @Column(name = "PLACA")
    private String placa;
    
    @Column(name = "AÑO")
    private int año;
    
    @Column(name = "FECHA")
    private String fecha;
    
    @Column(name = "CIUDAD")
    private String ciudad;
    
    @Column(name = "CILINDRAJE")
    private int cilindraje;
}
