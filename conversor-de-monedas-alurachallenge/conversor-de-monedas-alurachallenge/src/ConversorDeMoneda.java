import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConversorDeMoneda {

    private static DateTimeFormatter formateadorFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static ServicioConversion servicioConversion = new ServicioConversion();
    private static GestorHistorial gestorHistorial = new GestorHistorial("Historial_conversiones.txt");
    private static GestorJson gestorJson = new GestorJson("Historial_converisones.json");

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean continuarEjecutando = true;

        //menu principal
        while (continuarEjecutando){
            System.out.println("\n****************************************************************");
            System.out.println("BIENVENIDO(A) AL CONVERSOR DE MONEDAS");
            System.out.println("Elige la moneda que desea de convertir:\n" +
            "1. Dólar Estadounidense (USD) a Real Brasileño       (BRL)\n" +
            "2. Real Brasileño       (BRL) a Dólar Estadounidense (USD)\n" +
            "3. Peso Chileno         (CLP) a Dólar Estadounidense (USD)\n" +
            "4. Dólar Estadounidense (USD) a Peso Chileno         (CLP)\n" +
            "5. Peso Chileno         (CLP) a Real Brasileño       (BRL)\n" +
            "6. Real Brasileño       (BRL) a Peso Chileno         (CLP)\n" +
            "7. Ver historial de converisones\n" +
            "8. Salir\n" +
            "****************************************************************");

            int opcion = scanner.nextInt();
            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion){
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case 2:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaOrigen = "CLP";
                    monedaDestino = "USD";
                    break;
                case 4:
                    monedaOrigen = "USD";
                    monedaDestino = "CLP";
                    break;
                case 5:
                    monedaOrigen = "CLP";
                    monedaDestino = "BRL";
                    break;
                case 6:
                    monedaOrigen = "BRL";
                    monedaDestino = "CLP";
                    break;
                case 7:
                    gestorHistorial.mostraHistorial();
                    continue;
                case 8:
                    continuarEjecutando = false;
                    System.out.println("CERRANDO EL CONVERSOR DE MONEDAS.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;

            }

            if (opcion >= 1 && opcion <= 6){
                System.out.println("Introduce la cantidad que deseas convertir: ");
                double cantidad = scanner.nextDouble();

                try {
                    double resultado = servicioConversion.convertirMoneda(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("\nEl valor de: " + cantidad + " " + monedaOrigen + " son " + String.format("%.2f", resultado) + " " + monedaDestino);

                    //agregar al historial de texto de conversiones
                    gestorHistorial.agregarConversionAlHistorial(cantidad, monedaOrigen, resultado, monedaDestino);


                    //fecha y hora para el historial JSON
                    String fechaHoraActual = LocalDateTime.now().format(formateadorFechaHora);

                    //agregar al historial JSON
                    gestorJson.agregarConversionJson(cantidad, monedaOrigen, resultado, monedaDestino, fechaHoraActual);

                }catch (Exception e){
                    System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
