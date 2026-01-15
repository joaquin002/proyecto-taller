package Clases;

public class Cliente extends Persona {

    private long telefono;
    private String direccion;

    public Cliente(int DNI, String nombre, String apellido, String email, String contrasenia, long telefono, String direccion) {
        super(DNI, nombre, apellido, email, contrasenia);
        this.telefono = telefono;
        this.direccion = direccion;
    }


}
