package co.edu.eci.cvds.model;

public class Trabajador extends Usuario {

    private String cargo;
    private int numeroContrato;
    private String acuerdos;


    public Trabajador(String nombre, String tipoId, int numeroId, String correo, String direccion,
                      String cargo, int numeroContrato, String acuerdos) {
        super(nombre, tipoId, numeroId, correo, direccion);
        this.cargo = cargo;
        this.numeroContrato = numeroContrato;
        this.acuerdos = acuerdos;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de ID: " + tipoId);
        System.out.println("Número de ID: " + numeroId);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Cargo: " + cargo);
        System.out.println("Número de Contrato: " + numeroContrato);
        System.out.println("Acuerdos: " + acuerdos);
    }
}