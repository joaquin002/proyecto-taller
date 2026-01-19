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


    public void terminarTurno() throws EstadoIncorrecto {
        if(estadoTurno != EstadoTurno.EN_PROCESO) {
            throw new EstadoIncorrecto("Solo se pueden finalizar trabajos que esten en proceso");
        }
        if(diagnostico.isEmpty() || diagnostico == null){
            throw new EstadoIncorrecto("No se puede finalizar el trabajo sin dar un diagnostico");
        }
        this.estadoTurno = EstadoTurno.ATENDIDO;
    }


    public void cancelarTurno() throws EstadoIncorrecto {

        if(this.estadoTurno == EstadoTurno.ATENDIDO ||  this.estadoTurno == EstadoTurno.CANCELADO) {
            throw new EstadoIncorrecto("El turno no se puede cancelar (Fue finalizado o ya cancelado)");
        }
        estadoTurno = EstadoTurno.CANCELADO;
    }





    public int getIdTurno() {
        return idTurno;
    }

    public TipoTurno getTipoTurno() {
        return tipoTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public MotivoTurno getMotivoTurno() {
        return motivoTurno;
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
