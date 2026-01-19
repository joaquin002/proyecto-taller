import Clases.Cliente;
import Clases.Sistema;
import Clases.Vehiculo;
import Enums.MotivoTurno;
import Enums.TipoTurno;
import Excepciones.CitaInvalidaExcep;
import Excepciones.EstadoIncorrecto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws EstadoIncorrecto, CitaInvalidaExcep {

    Sistema sistemaTest = new Sistema();
    Cliente clienteTest = new Cliente(123123,"Emmanuel","AAAA","mailtest@gmail.com","contra1234",21354123,"Alguna calle123");
    Vehiculo vehiculoTest = new Vehiculo("EDA 223","Ford","Ranger XLT",240000,clienteTest);

    /// Esto es una prueba de la fecha, despues hay que mejorar para que se haga de un solo formato la fecha y la hora
    LocalDate fecha1 = LocalDate.parse("2026-01-15");
    LocalTime hora1 = LocalTime.parse("10:30");
    sistemaTest.agendarTurno(fecha1,hora1, TipoTurno.DIAGNOSTICO, MotivoTurno.MANTENIMIENTO_MOTOR,vehiculoTest,clienteTest);
    sistemaTest.agendarTurno(fecha1,hora1, TipoTurno.REPARACION, MotivoTurno.SUSPENCION,vehiculoTest,clienteTest);
    sistemaTest.registrarDiagnosticoTurno(2,"Cambio de amortiguadores",350000,250000,3);
    System.out.println(sistemaTest.listar());
}
