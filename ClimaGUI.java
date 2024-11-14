import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;

public class ClimaGUI extends JFrame {

    private JButton btnEncendido;
    private JLabel lblEstado;
    private JButton btnTempUp;
    private JButton btnTempDown;
    private JTextField textTemp;
    private JCheckBox checkAuto;
    private JSlider sliderIntensidad;
    private JCheckBox checkEco;
    private JComboBox<String> comboDireccion;
    private JSlider sliderAsientosDelanteros;
    private JSlider sliderAsientosTraseros;
    private JButton btnVerHistorial;
    private JButton btnAgendarMantenimiento;
    private JCheckBox checkDesempanador;
    private IClimaB miBMW;

    private ArrayList<String> historialCitas;

    public ClimaGUI() {
        setTitle("Control de Clima");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        historialCitas = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        //Crear el vehículo
        IClimaB miBMW = new VehiculoBMW();

        // Botón Encendido
        btnEncendido = new JButton("O");
        btnEncendido.setFont(new Font("Arial", Font.BOLD, 14));
        btnEncendido.setBounds(20, 10, 50, 30);
        panel.add(btnEncendido);

         // label Encendido
         lblEstado = new JLabel(miBMW.apagar());
         lblEstado.setFont(new Font("Arial", Font.BOLD, 14));
         lblEstado.setBounds(100, 10, 400, 30);
         panel.add(lblEstado);

        // Temperatura
        JLabel labelTemp = new JLabel("Temperatura:");
        labelTemp.setFont(new Font("Arial", Font.PLAIN, 12));
        labelTemp.setBounds(20, 50, 100, 30);
        panel.add(labelTemp);

        btnTempUp = new JButton("+");
        btnTempUp.setBounds(120, 50, 45, 30);
        panel.add(btnTempUp);

        textTemp = new JTextField(miBMW.ajustarTemperatura(0) + "°C");
        textTemp.setHorizontalAlignment(JTextField.CENTER);
        textTemp.setEditable(false);
        textTemp.setBounds(175, 50, 50, 30);
        panel.add(textTemp);

        btnTempDown = new JButton("-");
        btnTempDown.setBounds(235, 50, 45, 30);
        panel.add(btnTempDown);

        
        checkAuto = new JCheckBox("Modo Automático");
        checkAuto.setBounds(290, 50, 150, 30);
        panel.add(checkAuto);
        

        // Ventilación
        JLabel labelVent = new JLabel("Ventilación:");
        labelVent.setFont(new Font("Arial", Font.BOLD, 14));
        labelVent.setBounds(20, 100, 100, 30);
        panel.add(labelVent);

        JLabel labelIntensidad = new JLabel("Intensidad");
        labelIntensidad.setFont(new Font("Arial", Font.PLAIN, 12));
        labelIntensidad.setBounds(20, 130, 100, 30);
        panel.add(labelIntensidad);

        sliderIntensidad = new JSlider(0, 3, 1);
        sliderIntensidad.setMajorTickSpacing(1);
        sliderIntensidad.setPaintTicks(true);
        sliderIntensidad.setPaintLabels(true);
        sliderIntensidad.setBounds(130, 130, 200, 50);
        panel.add(sliderIntensidad);

        checkEco = new JCheckBox("Modo Eco");
        checkEco.setBounds(340, 130, 100, 30);
        panel.add(checkEco);

        JLabel labelDireccion = new JLabel("Dirección");
        labelDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
        labelDireccion.setBounds(20, 190, 100, 30);
        panel.add(labelDireccion);

        comboDireccion = new JComboBox<>(new String[] {"Todo", "Frente", "Parabrisas", "Pies"});
        comboDireccion.setBounds(130, 190, 100, 30);
        panel.add(comboDireccion);

        // Calefacción
        JLabel labelCalef = new JLabel("Calefacción:");
        labelCalef.setFont(new Font("Arial", Font.BOLD, 14));
        labelCalef.setBounds(20, 240, 100, 30);
        panel.add(labelCalef);

        JLabel labelAsientosDelanteros = new JLabel("Asientos Delanteros");
        labelAsientosDelanteros.setFont(new Font("Arial", Font.PLAIN, 12));
        labelAsientosDelanteros.setBounds(20, 270, 120, 30);
        panel.add(labelAsientosDelanteros);

        sliderAsientosDelanteros = new JSlider(0, 3, 1);
        sliderAsientosDelanteros.setMajorTickSpacing(1);
        sliderAsientosDelanteros.setPaintTicks(true);
        sliderAsientosDelanteros.setPaintLabels(true);
        sliderAsientosDelanteros.setBounds(150, 270, 200, 50);
        panel.add(sliderAsientosDelanteros);

        JLabel labelAsientosTraseros = new JLabel("Asientos Traseros");
        labelAsientosTraseros.setFont(new Font("Arial", Font.PLAIN, 12));
        labelAsientosTraseros.setBounds(20, 330, 120, 30);
        panel.add(labelAsientosTraseros);

        sliderAsientosTraseros = new JSlider(0, 3, 1);
        sliderAsientosTraseros.setMajorTickSpacing(1);
        sliderAsientosTraseros.setPaintTicks(true);
        sliderAsientosTraseros.setPaintLabels(true);
        sliderAsientosTraseros.setBounds(150, 330, 200, 50);
        panel.add(sliderAsientosTraseros);

        // Mantenimiento
        JLabel labelMantenimiento = new JLabel("Mantenimiento:");
        labelMantenimiento.setFont(new Font("Arial", Font.BOLD, 14));
        labelMantenimiento.setBounds(20, 390, 100, 30);
        panel.add(labelMantenimiento);

        btnVerHistorial = new JButton("Ver Historial");
        btnVerHistorial.setBounds(130, 390, 120, 30);
        panel.add(btnVerHistorial);

        btnAgendarMantenimiento = new JButton("Agendar Mantenimiento");
        btnAgendarMantenimiento.setBounds(260, 390, 150, 30);
        panel.add(btnAgendarMantenimiento);

        // Desempañador
        checkDesempanador = new JCheckBox("Desempañador");
        checkDesempanador.setBounds(20, 430, 150, 30);
        panel.add(checkDesempanador);

        // Agregar el panel al marco, apagar, crear la controladora
        add(panel);
        toggleComponents(false);
        

        // Funcionalidad de los botones de temperatura
        btnTempUp.addActionListener(e -> ajustarTemperatura(1));
        btnTempDown.addActionListener(e -> ajustarTemperatura(-1));

        //Funcionalidad del Modo automático
        checkAuto.addItemListener(new ItemListener() {
            @Override
	        public void itemStateChanged(ItemEvent e) {
		        if (checkAuto.isSelected()) {
                    int tempAmbiente = 25;
                    textTemp.setText(tempAmbiente + "°C"); 
                    JOptionPane.showMessageDialog(null, 
                    miBMW.modoAutomatico(25), 
                    "Modo Automático", 
                    JOptionPane.ERROR_MESSAGE);
            }}
        });

        //Funcionalidad del Modo eco
        checkEco.addItemListener(new ItemListener() {
            @Override
	        public void itemStateChanged(ItemEvent e) {
		        if (checkEco.isSelected()) {
                    sliderAsientosDelanteros.setValue(1);
                    sliderAsientosTraseros.setValue(1);
                    sliderIntensidad.setValue(1); }}
        });

        // Funcionalidad del botón "Ver Historial"
        btnVerHistorial.addActionListener(e -> mostrarHistorialCitas());

        // Funcionalidad del botón "Agendar Mantenimiento"
        btnAgendarMantenimiento.addActionListener(e -> mostrarVentanaMantenimiento());

        // Funcionalidad del botón "Encendido"
        btnEncendido.addActionListener(new ActionListener() {
        private boolean encendido = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                encendido = !encendido;
                toggleComponents(encendido);
                lblEstado.setText(encendido ? miBMW.encender() : miBMW.apagar());
            }
        });
    }

    private void toggleComponents(boolean estado) {
        btnTempUp.setEnabled(estado);
        btnTempDown.setEnabled(estado);
        textTemp.setEnabled(estado);
        checkAuto.setEnabled(estado);
        sliderIntensidad.setEnabled(estado);
        sliderIntensidad.setValue(0);
        checkEco.setEnabled(estado);
        comboDireccion.setEnabled(estado);
        sliderAsientosDelanteros.setEnabled(estado);
        sliderAsientosDelanteros.setValue(0);
        sliderAsientosTraseros.setEnabled(estado);
        sliderAsientosTraseros.setValue(0);
        btnVerHistorial.setEnabled(estado);
        btnAgendarMantenimiento.setEnabled(estado);
        checkDesempanador.setEnabled(estado);
    }

    private void ajustarTemperatura(int cambio) {
        textTemp.setText(miBMW.ajustarTemperatura(cambio) + "°C");
        checkAuto.setSelected(false);
    }

    private void mostrarVentanaMantenimiento() {
        JFrame ventanaMantenimiento = new JFrame("Agendar Mantenimiento");
        ventanaMantenimiento.setSize(300, 200);
        ventanaMantenimiento.setLocationRelativeTo(this);

        JPanel panelMantenimiento = new JPanel();
        panelMantenimiento.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelFecha = new JLabel("Fecha:");
        JTextField textFecha = new JTextField();
        JLabel labelHora = new JLabel("Hora:");
        JTextField textHora = new JTextField();

        JButton btnGuardarCita = new JButton("Guardar Cita");
        btnGuardarCita.addActionListener(e -> {
            String fecha = textFecha.getText();
            String hora = textHora.getText();
            if (!fecha.isEmpty() && !hora.isEmpty()) {
                historialCitas.add("Fecha: " + fecha + ", Hora: " + hora);
                JOptionPane.showMessageDialog(this, "Cita guardada exitosamente.");
                ventanaMantenimiento.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese fecha y hora.");
            }
        });

        panelMantenimiento.add(labelFecha);
        panelMantenimiento.add(textFecha);
        panelMantenimiento.add(labelHora);
        panelMantenimiento.add(textHora);
        panelMantenimiento.add(new JLabel());
        panelMantenimiento.add(btnGuardarCita);

        ventanaMantenimiento.add(panelMantenimiento);
        ventanaMantenimiento.setVisible(true);
    }

    // Funcionalidad del botón "Ver Historial"
    private void mostrarHistorialCitas() {
        if (historialCitas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay citas de mantenimiento agendadas.");
        } else {
            StringBuilder historial = new StringBuilder("Historial de Citas de Mantenimiento:\n");
            for (String cita : historialCitas) {
                historial.append(cita).append("\n");
            }
            JOptionPane.showMessageDialog(this, historial.toString());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClimaGUI controlClima = new ClimaGUI();
            controlClima.setVisible(true);
        });
    }
}
