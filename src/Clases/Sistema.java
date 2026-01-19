package Clases;

import Enums.MotivoTurno;
import Enums.TipoTurno;
import Excepciones.CitaInvalidaExcep;
import Excepciones.EstadoIncorrecto;
import Excepciones.ExcepcionNoCoincide;
import Handlers.Validaciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sistema {

        private ArrayList<Turno> turnos;

    public Sistema() {
        this.turnos = new ArrayList<>();
    }





    ///  METODOS DE REGISTRO
    public void agendarTurno(LocalDate fecha, LocalTime hora, TipoTurno tipoTurno, MotivoTurno motivoTurno, Vehiculo vehiculo, Cliente duenio) throws CitaInvalidaExcep, ExcepcionNoCoincide {

        Validaciones.validarFecha(fecha);
        Validaciones.validarHorarioRango(hora);
        Validaciones.validarRangoAnio(fecha);
        if(existeTurno(fecha, hora)){
            throw new CitaInvalidaExcep("Ya existe un turno en este dia y hora");
        }
        Turno t = new Turno(fecha, hora, tipoTurno, motivoTurno, vehiculo, duenio);
        turnos.add(t);
    }

    public void registrarDiagnosticoTurno( int ID, String diagnostico, float costoRepuestos, float costoManoObra, LocalDate plazoEntrega) throws CitaInvalidaExcep,EstadoIncorrecto {

        Turno t = buscarTurnoID(ID);
        if (t!= null){
                t.registrarDiagnostico(diagnostico, costoRepuestos, costoManoObra, plazoEntrega);
        }else {
            throw new CitaInvalidaExcep("El turno no existe");
        }
    }


    /// METODOS DE FINALIZAR TURNO Y CANCELAR

    public void finalizarTurno(int id) throws CitaInvalidaExcep, EstadoIncorrecto {

        Turno t = buscarTurnoID(id);
        if(t== null){
            throw new CitaInvalidaExcep("El turno es inexistente");
        }

        t.terminarTurno();
    }

    public void cancelarTurno(int id) throws CitaInvalidaExcep, EstadoIncorrecto {

        Turno t = buscarTurnoID(id);
        if(t== null){
            throw new CitaInvalidaExcep("El turno es inexistente");
        }

        t.terminarTurno();
    }



    /// metodos de verificacion y/o busqueda
    private boolean existeTurno(LocalDate fecha, LocalTime hora) {
        for (Turno t : turnos) {
            if (t.getFecha().equals(fecha) &&
                    t.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }


    public Turno buscarTurnoID(int id){

        for(Turno t : turnos){
            if (t.getIdTurno() == id){
                return t;
            }
        }
        return null;
    }


    ///  metodo temporal para listar

    public String listar(){
        String lista = "";
        for (Turno t : turnos) {
            lista += t.toString();
        }

        return lista;
    }
}
