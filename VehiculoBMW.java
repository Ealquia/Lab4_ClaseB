import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehiculoBMW implements IClimaB{
    protected boolean encendido;
    protected int temperatura;
    protected int intensidadVentilacion;
    protected String direccionVentilacion;
    protected boolean modoEco;
    protected int asientosDelanteros;
    protected int asientosTraseros;
    protected boolean desempanador;
    protected List<String> historial;
    protected Date citaMantenimiento;

    public VehiculoBMW() {
        this.encendido = false;
        this.temperatura = 25;  // Temperatura inicial
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
    public int ajustarTemperatura(int cambio) {
        this.temperatura  += cambio;
        return this.temperatura;
    }

    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        this.temperatura = temperaturaAmbiente;  // Ajuste ejemplo
        return "Se ha activado el modo automático. \n La temperatura interna se ajustará a la ambiente, que es de:  " + temperaturaAmbiente + "°C";
    }

    @Override
    public String ajustarVentilacion(int intensidadVentilacion) {
        if (intensidadVentilacion >= 1 && intensidadVentilacion <= 3) 
            this.intensidadVentilacion = intensidadVentilacion;
        return "Intensidad de ventilación ajustada a nivel " + intensidadVentilacion;
    }

    @Override
    public String activarModoEco() {
        modoEco = !modoEco;
        return "Se ha activado el modo de ahorro de energía";
    }

    @Override
    public String ajustarDireccionVentilacion(String direccion) {
        if (direccion.equals("parabrisas") || direccion.equals("frontal") ||
            direccion.equals("pies") || direccion.equals("todo")) {
            this.direccionVentilacion = direccion;
        } 
        return "La dirección de la ventilación se ha ajustado a " + direccion;
    }

    @Override
    public String activarCalefaccionAsientos(int nivelDelantero, int nivelTrasero){
        return """
                Se ha activado la calefacción en los asientos delanteros a nivel """ + nivelDelantero + """
                Se ha activado la calefacción en los asientos traseros a nivel """ + nivelTrasero;
    }

    @Override
    public String activarDesempañador() {
        desempanador = true;
        return "Desempañador encendido.";
    }

    @Override
    public String desactivarDesempañador() {
        desempanador = false;
        historial.add("Desempanador apagado");
        return "Desempañador apagado.";
    }

    @Override
    public String activarCalefaccionRapida() {
        return "Calefacción rápida activada.";
    }

    @Override
    public List<String> verHistorialMantenimiento() {
        return historial;
    }

    @Override
    public String programarMantenimiento(Date fecha) {
        return "Mantenimiento programado para " + fecha.toString();
    }
}
