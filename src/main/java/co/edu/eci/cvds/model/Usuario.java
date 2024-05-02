package co.edu.eci.cvds.model;


public abstract class Usuario {
    protected String nombre;
    protected String tipoId;
    protected int numeroId;
    protected String correo;
    protected String direccion;

    public Usuario(String nombre, String tipoId, int numeroId, String correo, String direccion) {
        this.nombre = nombre;
        this.tipoId = tipoId;
        this.numeroId = numeroId;
        this.correo = correo;
        this.direccion = direccion;
    }
    public abstract void mostrarInformacion();
}