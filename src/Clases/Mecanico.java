package Clases;

import Enums.HorarioTrabajo;

public class Mecanico  extends Persona {

    private HorarioTrabajo turnoTrabajo;
    private boolean cuenta_activa;

    public Mecanico(int DNI, String nombre, String apellido, String email, String contrasenia, HorarioTrabajo turnoTrabajo, boolean cuenta_activa) {
        super(DNI, nombre, apellido, email, contrasenia);
        this.turnoTrabajo = turnoTrabajo;
        this.cuenta_activa = cuenta_activa;
    }
}
