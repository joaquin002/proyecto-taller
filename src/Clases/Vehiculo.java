package Clases;

import java.util.HashSet;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int kilometraje;
    private Cliente duenio;
    private HashSet<Turno> historialTaller;


    public Vehiculo(String patente, String marca, String modelo, int kilometraje, Cliente duenio) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.duenio = duenio;
        this.historialTaller = new HashSet<>();
    }
}
