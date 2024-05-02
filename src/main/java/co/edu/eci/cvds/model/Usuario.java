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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public abstract void mostrarInformacion();
}