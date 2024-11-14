import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehiculo implements IClimaB {
    private boolean estado;
    private float temperatura;
    private int nivelVentilacion;
    private boolean modoEco;
    private String direccionVentilacion;
    private boolean desempañadorActivo;
    private int asientosDelanteros;
    private int asientosTraseros;
    private List<String> mantenimiento;
    private Date citaMantenimiento;

    public Vehiculo() {
        this.estado = false;
        this.temperatura = 20.0f;  // Temperatura inicial
        this.nivelVentilacion = 0;
        this.modoEco = false;
        this.direccionVentilacion = "frontal";
        this.desempañadorActivo = false;
        this.asientosDelanteros = 0;
        this.asientosTraseros = 0;
        this.mantenimiento = new ArrayList<>();
        this.citaMantenimiento = null;
    }

    @Override
    public String encender() {
        estado = true;
        return "Sistema de climatización encendido.";
    }

    @Override
    public String apagar() {
        estado = false;
        return "Sistema de climatización apagado.";
    }

    @Override
    public int ajustarTemperatura(int incremento) {
        temperatura += incremento;
        return (int) temperatura;
    }

    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        temperatura = temperaturaAmbiente > 25 ? 22 : 24;
        return String.valueOf(temperatura);
    }

    @Override
    public String ajustarVentilacion(int intensidad) {
        if (intensidad >= 0 && intensidad <= 3) {
            nivelVentilacion = intensidad;
            return "Nivel de ventilación ajustado a: " + nivelVentilacion;
        } else {
            return "Nivel de ventilación inválido. Debe estar entre 0 y 3.";
        }
    }

    @Override
    public String activarModoEco() {
        modoEco = true;
        nivelVentilacion = Math.max(nivelVentilacion - 1, 0);  // Reduce intensidad en modo eco
        return "Modo Eco activado. Nivel de ventilación ajustado a: " + nivelVentilacion;
    }

    @Override
    public String ajustarDireccionVentilacion(String direccion) {
        direccionVentilacion = direccion;
        return "Dirección de ventilación ajustada a: " + direccionVentilacion;
    }

    @Override
    public String activarCalefaccionAsientos(int nivelDelantero, int nivelTrasero) {
        if (nivelDelantero >= 0 && nivelDelantero <= 3) {
            asientosDelanteros = nivelDelantero;
            return "Calefacción de asientos delanteros ajustada a: " + asientosDelanteros;
        }
        if (nivelTrasero >= 0 && nivelTrasero <= 3) {
            asientosTraseros = nivelTrasero;
            return "Calefacción de asientos traseros ajustada a: " + asientosTraseros;
        }

        else {
            return "aqui hay error papi";
        }
    }

    @Override
    public String activarCalefaccionRapida() {
        temperatura = 28.0f;
        return "Calefacción rápida activada. Temperatura ajustada a: " + temperatura + "°C";
    }

    @Override
    public String activarDesempañador() {
        desempañadorActivo = true;
        return "Desempañador activado.";
    }

    @Override
    public String desactivarDesempañador() {
        desempañadorActivo = false;
        return "Desempañador desactivado.";
    }

    @Override
    public String programarMantenimiento(Date fecha) {
        citaMantenimiento = fecha;
        mantenimiento.add("Mantenimiento programado para: " + fecha.toString());
        return "Cita de mantenimiento programada para: " + fecha;
    }

    @Override
    public List<String> verHistorialMantenimiento() {
        return mantenimiento;
    }
}