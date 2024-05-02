package co.edu.eci.cvds.model;

public class Proveedor extends Usuario {
    private String razonSocial;
    private String tipo;
    private String especificaciones;


    public Proveedor(String nombre, String tipoId, int numeroId, String correo, String direccion,
                     String razonSocial, String tipo, String especificaciones) {
        super(nombre, tipoId, numeroId, correo, direccion);
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.especificaciones = especificaciones;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de ID: " + tipoId);
        System.out.println("Número de ID: " + numeroId);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Razón Social: " + razonSocial);
        System.out.println("Tipo: " + tipo);
        System.out.println("Especificaciones: " + especificaciones);
    }
}