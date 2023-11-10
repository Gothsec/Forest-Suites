/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import utilidades.LimitadorCaracteres;
import modelo.ModeloCrearCliente;

public class VistaCrearCliente extends JFrame{
    public VistaMenuPrincipal obj_menu;
    public LimitadorCaracteres obj_limitador;
    public JButton btnGuardarReserva, btnLimpiarReserva, btnVolver;

    public JTextField textFieldNombre, textFieldId, textFieldEmail, textFieldCheckin, textFieldCheckout;
    public static String[] opcionesHabitacion = {"Individual", "Doble", "Matrimonial", "Suite"};
    public JComboBox<String> comboBoxHabitacion;
    
    public JButton selectCheckin, selectCheckout;
    public JLabel labelMensaje;
    
    ModeloCrearCliente objModelo = new ModeloCrearCliente(this);
    
    public VistaCrearCliente(VistaMenuPrincipal obj_menu) {
        super("Nueva Cliente");
        this.obj_menu = obj_menu;
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        createGUI();

        setVisible(true);
    }
    
    public void createGUI () {
        JLabel label = new JLabel("Crear Cliente");
        ImageIcon icon = new ImageIcon(getClass().getResource("../iconos/usuario1.png"));
        
        label.setIcon(icon);
        label.setBounds(0, 0, 400, 50);
        label.setBorder(new EtchedBorder());
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.setHorizontalAlignment(JLabel.CENTER); // Texto centrado
        add(label);
        // Labels y TextFields
        
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(30, 60, 100, 30);
        add(labelNombre);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setDocument(new LimitadorCaracteres(textFieldNombre, 30, 1));
        textFieldNombre.setBounds(140, 60, 200, 30);
        add(textFieldNombre);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(30, 100, 100, 30);
        add(labelId);
        
        textFieldId = new JTextField();
        //textFieldId.setText(String.valueOf(objModel.generateNextId()));
        textFieldId.setBounds(140, 100, 100, 30);
        textFieldId.setEditable(false);
        add(textFieldId);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 140, 100, 30);
        add(labelEmail);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setDocument(new LimitadorCaracteres(textFieldEmail, 40, 5));
        textFieldEmail.setBounds(140, 140, 200, 30);
        add(textFieldEmail);

        JLabel labelHabitacion = new JLabel("Habitación:");
        labelHabitacion.setBounds(30, 180, 100, 30);
        add(labelHabitacion);
        
        comboBoxHabitacion = new JComboBox<>(opcionesHabitacion);
        comboBoxHabitacion.setBounds(140, 180, 200, 30);
        add(comboBoxHabitacion);

        // Botones y etiquetas adicionales
        JLabel labelCheckin = new JLabel("Check-in:");
        labelCheckin.setBounds(30, 220, 100, 30);
        add(labelCheckin);

        JLabel labelCheckout = new JLabel("Check-out:");
        labelCheckout.setBounds(30, 260, 100, 30);
        add(labelCheckout);

        selectCheckin = new JButton("Fecha");
        selectCheckin.setBounds(140, 220, 100, 30);
        add(selectCheckin);
        
        textFieldCheckin = new JTextField();
        textFieldCheckin.setBounds(250, 220, 90, 30);
        textFieldCheckin.setEditable(false); // Deshabilitar la edición de la fecha
        add(textFieldCheckin);

        selectCheckout = new JButton("Fecha");
        selectCheckout.setBounds(140, 260, 100, 30);
        add(selectCheckout);
        
        textFieldCheckout = new JTextField();
        textFieldCheckout.setBounds(250, 260, 90, 30);
        textFieldCheckout.setEditable(false); 
        add(textFieldCheckout);

        // Botones principales
        btnGuardarReserva = new JButton("Guardar");
        btnGuardarReserva.setBounds(130, 320, 100, 30);
        add(btnGuardarReserva);

        btnLimpiarReserva = new JButton("Limpiar");
        btnLimpiarReserva.setBounds(240, 320, 100, 30);
        add(btnLimpiarReserva);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(30, 320, 90, 30);
        add(btnVolver);

        // Mensaje
        labelMensaje = new JLabel("");
        labelMensaje.setBounds(20, 360, 300, 30);
        labelMensaje.setForeground(Color.GRAY); 
        add(labelMensaje);
    }
}