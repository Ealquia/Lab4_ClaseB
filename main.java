import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        IClimaB miVehiculo = new Vehiculo();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        do {
            System.out.println("\n--- Menú del sistema de climatización ---");
            System.out.println("1. Encender sistema");
            System.out.println("2. Apagar sistema");
            System.out.println("3. Ajustar temperatura");
            System.out.println("4. Modo automático");
            System.out.println("5. Ajustar ventilación");
            System.out.println("6. Activar modo Eco");
            System.out.println("7. Ajustar dirección de ventilación");
            System.out.println("8. Activar calefacción de asientos");
            System.out.println("9. Activar calefacción rápida");
            System.out.println("10. Activar desempañador");
            System.out.println("11. Desactivar desempañador");
            System.out.println("12. Programar mantenimiento");
            System.out.println("13. Ver historial de mantenimiento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> System.out.print(miVehiculo.encender());
                case 2 -> System.out.print(miVehiculo.apagar());
                case 3 -> {
                    System.out.print("Ingrese incremento de temperatura: ");
                    int incremento = scanner.nextInt();
                    System.out.println("Temperatura ajustada a: " + miVehiculo.ajustarTemperatura(incremento) + "°C");
                }
                case 4 -> {
                    System.out.print("Ingrese temperatura ambiente: ");
                    int tempAmbiente = scanner.nextInt();
                    System.out.println(miVehiculo.modoAutomatico(tempAmbiente));
                }
                case 5 -> {
                    System.out.print("Ingrese nivel de ventilación (0 a 3): ");
                    int intensidad = scanner.nextInt();
                    System.out.println(miVehiculo.ajustarVentilacion(intensidad));
                }
                case 6 -> miVehiculo.activarModoEco();
                case 7 -> {
                    System.out.print("Ingrese dirección de ventilación (parabrisas, frontal, pies, todo): ");
                    String direccion = scanner.next();
                    System.out.println(miVehiculo.ajustarDireccionVentilacion(direccion));
                }
                case 8 -> {
                    System.out.print("Ingrese nivel de calefacción para asientos delanteros (0 a 3): ");
                    int nivelDelantero = scanner.nextInt();
                    System.out.print("Ingrese nivel de calefacción para asientos traseros (0 a 3): ");
                    int nivelTrasero = scanner.nextInt();
                    System.out.println(miVehiculo.activarCalefaccionAsientos(nivelDelantero, nivelTrasero));
                }
                case 9 ->  System.out.println(miVehiculo.activarCalefaccionRapida());
                case 10 ->  System.out.println(miVehiculo.activarDesempañador());
                case 11 ->  System.out.println(miVehiculo.desactivarDesempañador());
                case 12 -> {
                    System.out.print("Ingrese fecha de mantenimiento (formato: yyyy-MM-dd): ");
                    String fechaInput = scanner.next();
                    try {
                        Date fecha = dateFormat.parse(fechaInput);
                        miVehiculo.programarMantenimiento(fecha);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha inválido. Intente de nuevo.");
                    }
                }
                case 13 -> System.out.println("Historial de mantenimiento: " + miVehiculo.verHistorialMantenimiento());
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}