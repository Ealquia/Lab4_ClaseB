import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehiculo implements IClimaB{
    protected boolean encendido;
    protected double temperatura;
    protected int intensidadVentilacion;
    protected String direccionVentilacion;
    protected boolean modoEco;
    protected int asientosDelanteros;
    protected int asientosTraseros;
    protected boolean desempanador;
    protected List<String> historial;
    protected Date citaMantenimiento;

    public Vehiculo() {
        this.encendido = false;
        this.temperatura = 25.0;  // Temperatura inicial
        this.intensidadVentilacion = 0;
        this.direccionVentilacion = "frontal";
        this.modoEco = false;
        this.asientosDelanteros = 0;
        this.asientosTraseros = 0;
        this.desempanador = false;
        this.historial = new ArrayList<>();
    }

    @Override
    public String encender() {
        encendido = true;
        return "Sistema de climatización encendido.";
    }

    @Override
    public String apagar() {
        encendido = false;
        return "Sistema de climatización apagado.";
    }

    @Override
    public double ajustarTemperatura(int cambio) {
        this.temperatura  += cambio;
        return this.temperatura;
    }

    @Override
    public double modoAutomatico(int temperaturaAmbiente) {
        this.temperatura = 25;  // Ajuste ejemplo
        return this.temperatura;
    }

    @Override
    public int ajustarVentilacion(int intensidadVentilacion) {
        if (intensidadVentilacion >= 1 && intensidadVentilacion <= 3) {
            this.intensidadVentilacion = intensidadVentilacion;
            historial.add("Intensidad de ventilación ajustada a nivel " + intensidadVentilacion);
        } else {
            historial.add("Error: Intensidad de ventilación fuera de rango.");
        }
        return this.intensidadVentilacion;
    }

    @Override
    public void activarModoEco() {
        modoEco = !modoEco;
    }

    @Override
    public void ajustarDireccionVentilacion(String direccion) {
        if (direccion.equals("parabrisas") || direccion.equals("frontal") ||
            direccion.equals("pies") || direccion.equals("todo")) {
            this.direccionVentilacion = direccion;
        } 
    }

    @Override
    public void activarCalefaccionAsientos(int nivelDelantero, int nivelTrasero){

    }

    @Override
    public String activarDesempañador() {
        desempanador = true;
        return "Desempanador encendido.";
    }

    @Override
    public String desactivarDesempañador() {
        desempanador = false;
        historial.add("Desempanador apagado");
        return "Desempanador apagado.";
    }

    @Override
    public void activarCalefaccionRapida() {
        this.temperatura = 30;
    }

    @Override
    public List<String> verHistorialMantenimiento() {
        return historial;
    }

    @Override
    public void programarMantenimiento(Date fecha) {
        historial.add("Mantenimiento programado para " + fecha.toString());
    }
}
