import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class GestorJson {

    private String rutaArchivoJson;
    private List<Conversion> listaConversiones;
    private Gson gson;

    public GestorJson(String rutaArchivoJson){
        this.rutaArchivoJson = rutaArchivoJson;
        this.listaConversiones = new ArrayList<>();
        this.gson = new GsonBuilder().setPrettyPrinting().create();

    }

    //clase interna para representar la conversion
    public static class Conversion {
        private double cantidad;
        private String monedaOrigen;
        private double resultado;
        private String monedaDestino;
        private String fechaHora;

        public Conversion(double cantidad, String monedaOrigen, double resultado, String monedaDestino, String fechaHora){
            this.cantidad = cantidad;
            this.monedaOrigen = monedaOrigen;
            this.resultado = resultado;
            this.monedaDestino = monedaDestino;
            this.fechaHora = fechaHora;
        }
    }

    //función para agregar una nueva conversión a la lista y guardarla en JSON
    public void agregarConversionJson(double cantidad, String monedaOrigen, double resultado, String monedaDestino, String fechaHora){
        Conversion conversion = new Conversion(cantidad, monedaOrigen, resultado, monedaDestino, fechaHora);
        listaConversiones.add(conversion);
        guardarEnJson();
    }

    //función para guardar la lista de conversiones en formato JSON
    private void guardarEnJson(){
        try (FileWriter escribir = new FileWriter(rutaArchivoJson)){
            gson.toJson(listaConversiones, escribir);
        }catch (IOException e){
            System.out.println("" + e.getMessage());
        }
    }

}
