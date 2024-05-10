package co.edu.eci.cvds.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "COMPRADOR")
public class Comprador {
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "TIPO_ID")
    private String tipoId;
    
    @Column(name = "NUMERO_ID")
    private String numeroId;
    
    @Column(name = "CORREO")
    private String correo;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "ESPECIFICACIONES")
    private String especificaciones;
    
    @Column(name = "TIPO")
    private String tipo;
    
    @Column(name = "MODO_DE_PAGO")
    private String modoDePago;
}
