
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorHistorial {

    private String rutaArchivo;
    private DateTimeFormatter formateadorFechaHora;

    public GestorHistorial(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
        this.formateadorFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        reiniciarHistorial();
    }



    // función para añadir una nueva conversión al historial
    public void agregarConversionAlHistorial(double cantidad, String monedaOrigen, double resultado, String monedaDestino){

        String fechaHoraActual = LocalDateTime.now().format(formateadorFechaHora);

        try (PrintWriter escribir = new PrintWriter(new FileWriter(rutaArchivo, true))){
            escribir.println("[" + fechaHoraActual + "] " + cantidad + " " + monedaOrigen + " son " + String.format("%.2f", resultado) + " " + monedaDestino);
        }catch (IOException e){
            System.out.println("Error al escribir en el historial de texto: " + e.getMessage());
        }
    }

    private void reiniciarHistorial(){
        try (PrintWriter escribir = new PrintWriter(new FileWriter(rutaArchivo))){
            escribir.println("Historial de Conversiones:");
        }catch (IOException e){
            System.out.println("" + e.getMessage());
        }
    }

    public void mostraHistorial(){
        try (BufferedReader leer = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while ((linea = leer.readLine()) != null){
                System.out.println(linea);
            }
        }catch (IOException e){
            System.out.println("Error al acceder al historial de conversiones. " + e.getMessage());
        }
    }
}
