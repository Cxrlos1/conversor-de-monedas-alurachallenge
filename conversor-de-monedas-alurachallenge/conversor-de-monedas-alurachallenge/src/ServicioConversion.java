public class ServicioConversion {


    private GestorHttp gestorHttp = new GestorHttp();

    public double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) throws Exception {
        double tasaCambio = gestorHttp.obtenerTasaCambio(monedaOrigen, monedaDestino);
        return cantidad * tasaCambio;
    }
}
