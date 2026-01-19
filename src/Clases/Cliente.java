package Clases;

import java.util.ArrayList;

public class Cliente extends Persona {

    private long telefono;
    private String direccion;
    private ArrayList<Vehiculo> vehiculos;
    public Cliente(int DNI, String nombre, String apellido, String email, String contrasenia, long telefono, String direccion) {
        super(DNI, nombre, apellido, email, contrasenia);
        this.telefono = telefono;
        this.direccion = direccion;
        vehiculos = new ArrayList<>();
    }


    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }


    public ArrayList<Vehiculo> getVehiculos() {
        for(Vehiculo v : vehiculos){
            Vehiculo aux = v;
        }

        return vehiculos;
    }
}
