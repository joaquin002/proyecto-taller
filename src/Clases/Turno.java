package Clases;

import Enums.EstadoTurno;
import Enums.MotivoTurno;
import Enums.TipoTurno;
import Excepciones.EstadoIncorrecto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurno;
    private static int countId = 0;
    private LocalDate fecha;
    private LocalTime hora;
    private TipoTurno tipoTurno;
    private MotivoTurno motivoTurno;
    private Vehiculo vehiculo;
    private Cliente duenio;
    private String diagnostico;
    private EstadoTurno estadoTurno;
    private float costoRepuestos;
    private float costoManoObra;
    private int plazoEntrega;


    public Turno(LocalDate fecha, LocalTime hora, TipoTurno tipoTurno, MotivoTurno motivoTurno, Vehiculo vehiculo, Cliente duenio) {

        this.idTurno = ++countId;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoTurno = tipoTurno;
        this.motivoTurno = motivoTurno;
        this.vehiculo = vehiculo;
        this.duenio = duenio;


        this.estadoTurno = EstadoTurno.PENDIENTE;
    }



    public void registrarDiagnostico(String diagnostico, float costoRepuestos, float costoManoObra, int plazoEntrega) throws EstadoIncorrecto {

        if(this.estadoTurno != EstadoTurno.PENDIENTE) {
            throw  new EstadoIncorrecto("Solo se puede diagnosticar un turno pendiente");
        }
        this.diagnostico = diagnostico;
        this.costoRepuestos = costoRepuestos;
        this.costoManoObra = costoManoObra;
        this.plazoEntrega = plazoEntrega;
        this.estadoTurno = EstadoTurno.EN_PROCESO;

    }


    public void terminarTurno() {
        this.estadoTurno = EstadoTurno.ATENDIDA;
    }


    public int getIdTurno() {
        return idTurno;
    }


    @Override
    public String toString() {
        return "Turno{" +
                "idTurno=" + idTurno +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", tipoTurno=" + tipoTurno +
                ", motivoTurno=" + motivoTurno +
                ", vehiculo=" + vehiculo +
                ", duenio=" + duenio +
                ", diagnostico='" + diagnostico + '\'' +
                ", estadoTurno=" + estadoTurno +
                ", costoRepuestos=" + costoRepuestos +
                ", costoManoObra=" + costoManoObra +
                ", plazoEntrega=" + plazoEntrega +
                '}';
    }
}
