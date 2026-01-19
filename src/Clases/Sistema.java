package Clases;

import Enums.MotivoTurno;
import Enums.TipoTurno;
import Excepciones.CitaInvalidaExcep;
import Excepciones.EstadoIncorrecto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sistema {

        private ArrayList<Turno> turnos;

    public Sistema() {
        this.turnos = new ArrayList<>();
    }

    public void agendarTurno(LocalDate fecha, LocalTime hora, TipoTurno tipoTurno, MotivoTurno motivoTurno, Vehiculo vehiculo, Cliente duenio){

        Turno t = new Turno(fecha, hora, tipoTurno, motivoTurno, vehiculo, duenio);
        turnos.add(t);
    }



    public Turno buscarTurnoID(int id){

        for(Turno t : turnos){
            if (t.getIdTurno() == id){
                return t;
            }
        }
        return null;
    }

    public void registrarDiagnosticoTurno( int ID, String diagnostico, float costoRepuestos, float costoManoObra, int plazoEntrega) throws CitaInvalidaExcep,EstadoIncorrecto {

        Turno t = buscarTurnoID(ID);
        if (t!= null){
                t.registrarDiagnostico(diagnostico, costoRepuestos, costoManoObra, plazoEntrega);
        }else {
            throw new CitaInvalidaExcep("El turno no existe");
        }
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
