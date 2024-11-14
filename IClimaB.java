import java.util.Date;
import java.util.List;

public interface IClimaB {
    String encender();
    String apagar();
    double ajustarTemperatura(int temperatura);
    double modoAutomatico(int temperaturaAmbiente);
    int ajustarVentilacion(int intensidadVentilacion);
    void activarModoEco();
    void ajustarDireccionVentilacion(String direccion);
    void activarCalefaccionAsientos(int nivelDelantero, int nivelTrasero);
    String activarDesempañador();
    void activarCalefaccionRapida();
    String desactivarDesempañador();
    List<String> verHistorialMantenimiento();
    void programarMantenimiento(Date fecha);
}
