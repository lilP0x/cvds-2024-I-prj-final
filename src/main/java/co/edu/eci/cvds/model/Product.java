package co.edu.eci.cvds.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 

@Data
@Entity
@Table(name = "PRODUCTO")
public class Product {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "VALOR")
    private int valor;
    @Column(name = "DESCUENTO")
    private double descuento;
    @Column(name = "DESCRIPCIONBREVE")
    private String descripcionBreve;
    @Column(name = "DESCRIPCIONTECNICA")
    private String descripcionTecnica;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "IMPUESTO")
    private int impuesto;
    @Column(name = "TIPOUSUARIO")
    private String tipoUsuario;
    @Column(name = "ICONURL")
    private String iconUrl;
    @ManyToMany(mappedBy = "products")
    private List<Carrito> carritos = new ArrayList<>();

}
