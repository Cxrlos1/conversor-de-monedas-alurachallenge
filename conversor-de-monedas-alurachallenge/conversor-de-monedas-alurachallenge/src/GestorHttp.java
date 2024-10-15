import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GestorHttp {

    private static final String CLAVE_API = "201ed078ed448fef5b09192b";
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/";

    //función para obtener las tasas de cambio usando HttpClient
    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws Exception {
        String urlCompleta = URL_API + CLAVE_API + "/latest/" + monedaOrigen;

        //crear el cliente HttpClient
        HttpClient cliente = HttpClient.newHttpClient();

        //crear la solicitud Httprequest
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
                .build();

        //enviar la colicitud y recibir la respuesta HttpResponse
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        //verificar el estado de la respuesta
        if (respuesta.statusCode() != 200){
            throw new Exception("Error en la solicitud HTTP: " + respuesta.statusCode());
        }

        //parsear la respuesta Json
        String bodyRespuesta = respuesta.body();
        JsonObject jsonObject = JsonParser.parseString(bodyRespuesta).getAsJsonObject();
        JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");

        return tasasConversion.get(monedaDestino).getAsDouble();
    }
}
