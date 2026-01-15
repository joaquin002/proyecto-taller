package Clases;

public abstract class Persona {

    private int DNI;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;


    public Persona(int DNI, String nombre, String apellido, String email, String contrasenia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}
