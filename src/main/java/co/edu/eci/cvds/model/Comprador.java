package co.edu.eci.cvds.model;

public class Comprador extends Usuario {
    private String especificaciones;
    private String tipo;
    private String modoPago;

    public Comprador(String nombre, String tipoId, int numeroId, String correo, String direccion,
                     String especificaciones, String tipo, String modoPago) {
        super(nombre, tipoId, numeroId, correo, direccion);
        this.especificaciones = especificaciones;
        this.tipo = tipo;
        this.modoPago = modoPago;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de ID: " + tipoId);
        System.out.println("Número de ID: " + numeroId);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Especificaciones: " + especificaciones);
        System.out.println("Tipo: " + tipo);
        System.out.println("Modo de Pago: " + modoPago);
    }
}