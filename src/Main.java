import Clases.Cliente;
import Clases.Mecanico;
import Clases.Sistema;
import Clases.Vehiculo;
import Enums.MotivoTurno;
import Enums.TipoTurno;
import Excepciones.CitaInvalidaExcep;
import Excepciones.EstadoIncorrecto;
import Excepciones.ExcepcionNoCoincide;
import Handlers.Validaciones;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws EstadoIncorrecto, CitaInvalidaExcep, ExcepcionNoCoincide {

    Sistema sistemaTest = new Sistema();
    Cliente clienteTest = new Cliente(123123, "Emmanuel", "AAAA", "mailtest@gmail.com", "contra1234", 21354123, "Alguna calle123");
    Vehiculo vehiculoTest = new Vehiculo("EDA 223", "Ford", "Ranger XLT", 240000, clienteTest);

    /// Esto es una prueba de la fecha, despues hay que mejorar para que se haga de un solo formato la fecha y la hora
    LocalDate fecha1 = LocalDate.parse("2026-01-22");
    LocalDate fecha2 = LocalDate.parse("2026-01-24");
    LocalTime hora1 = LocalTime.parse("10:30");
    ///  esto es para sacar la fecha estimada, despues en consola se pide dias aprox de trabajo y se saca con este metodo
    LocalDate entrega = fecha2.plusDays(3);
    try {
        sistemaTest.agendarTurno(fecha1, hora1, TipoTurno.DIAGNOSTICO, MotivoTurno.MANTENIMIENTO_MOTOR, vehiculoTest, clienteTest);
        sistemaTest.agendarTurno(fecha2, hora1, TipoTurno.REPARACION, MotivoTurno.SUSPENCION, vehiculoTest, clienteTest);
    } catch (CitaInvalidaExcep | ExcepcionNoCoincide e) {
        System.out.println(e.getMessage());
    }

    sistemaTest.registrarDiagnosticoTurno(2, "Cambio de amortiguadores", 350000, 250000, entrega);
    System.out.println(sistemaTest.listar());
}


        public static void MenuMecanico(Sistema sistema, Mecanico mecanico, Scanner sc) throws EstadoIncorrecto, CitaInvalidaExcep {


            int opcion;

            do {
                System.out.println("\n--- MENU EMPLEADO ---");
                System.out.println("1 - Ver turnos");
                System.out.println("2 - Registrar diagnostico");
                System.out.println("3 - Finalizar trabajo");
                System.out.println("4 - Reprogramar entrega");
                System.out.println("0 - Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        sistema.listar();
                        break;
                    case 2:
                        try {
                            System.out.print("ID turno: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Diagnostico: ");
                            String diag = sc.nextLine();

                            System.out.print("Costo repuestos: ");
                            float rep = sc.nextFloat();

                            System.out.print("Costo mano de obra: ");
                            float mano = sc.nextFloat();
                            sc.nextLine();

                            System.out.print("Fecha entrega (AAAA-MM-DD): ");
                            LocalDate entrega = LocalDate.parse(sc.nextLine());

                            sistema.registrarDiagnosticoTurno(id, diag, rep, mano, entrega);

                            System.out.println("Diagnostico registrado");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    case 3:
                        try {


                            System.out.print("Ingrese el ID del turno que finalizo: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            sistema.finalizarTurno(id);
                        } catch (CitaInvalidaExcep e) {
                            System.out.println(e.getMessage());
                        } catch (EstadoIncorrecto e) {
                            System.out.println(e.getMessage());
                        }
                        break;



                }

                break;

            } while (opcion != 0);
        }



        public static void menuCliente(Sistema sistema, Cliente cliente, Scanner sc) {

            int opcion;

            do {
                System.out.println("\n--- MENU CLIENTE ---");
                System.out.println("1 - Ver mis datos");
                System.out.println("2 - Ver mis vehiculos");
                System.out.println("3 - Ver mis turnos");
                System.out.println("4 - Agendar turno");
                System.out.println("5 - Cancelar turno");
                System.out.println("0 - Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 4:
                        try {
                            System.out.print("Fecha (AAAA-MM-DD): ");
                            LocalDate fecha = LocalDate.parse(sc.nextLine());
                            Validaciones.validarFecha(fecha);

                            System.out.print("Hora (HH:MM): ");
                            LocalTime hora = LocalTime.parse(sc.nextLine());
                            Validaciones.validarHorarioRango(hora);

                            System.out.print("Tipo (DIAGNOSTICO / REPARACION): ");
                            TipoTurno tipo = TipoTurno.valueOf(sc.nextLine().toUpperCase());

                            System.out.print("Motivo: ");
                            MotivoTurno motivo = MotivoTurno.valueOf(sc.nextLine().toUpperCase());

                            Vehiculo v = cliente.getVehiculos().get(0); // después elegís

                            sistema.agendarTurno(fecha, hora, tipo, motivo, v, cliente);

                            System.out.println("Turno agendado correctamente");

                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                  
                }
                        break;

            } while (opcion != 0);
        }