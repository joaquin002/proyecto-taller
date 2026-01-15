package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurno;
    private static  int countId = 0;
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


    public Turno(LocalDate fecha, LocalTime hora, TipoTurno tipoTurno, MotivoTurno motivoTurno, Vehiculo vehiculo, Cliente duenio, String diagnostico, EstadoTurno estadoTurno, float costoRepuestos, float costoManoObra, int plazoEntrega) {
        this.idTurno = ++countId;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoTurno = tipoTurno;
        this.motivoTurno = motivoTurno;
        this.vehiculo = vehiculo;
        this.duenio = duenio;
        this.diagnostico = diagnostico;
        this.estadoTurno = estadoTurno;
        this.costoRepuestos = costoRepuestos;
        this.costoManoObra = costoManoObra;
        this.plazoEntrega = plazoEntrega;
    }
}
