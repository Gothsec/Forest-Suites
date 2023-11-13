package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VistaEliminar extends JFrame {
    
    public JLabel label_titulo, label_id, label_nombre, label_email, label_habitacion, label_checkin, label_checkout;
    public JTextField textfield_id, textfield_nombre, textfield_email, textfield_habitacion, textfield_checkin, textfield_checkout;
    public JButton boton_buscar, boton_eliminar, boton_volver;
    public ImageIcon icono_volver;
    
    public VistaEliminar () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI () {
        
        // LABELS
        
        label_titulo = new JLabel("Eliminar");
        label_titulo.setBounds(190, 30, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        label_id = new JLabel("Id");
        label_id.setBounds(75, 100, 200, 40);
        label_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_id);
        
        // Separacion de elementos = 45
        
        label_nombre = new JLabel("Nombre");
        label_nombre.setBounds(75, 145, 200, 40);
        label_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_nombre);
        
        label_email = new JLabel("Email");
        label_email.setBounds(75, 190, 200, 40);
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_email);
        
        label_habitacion = new JLabel("Habitacion");
        label_habitacion.setBounds(75, 235, 200, 40);
        label_habitacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_habitacion);
        
        label_checkin = new JLabel("Check in");
        label_checkin.setBounds(75, 280, 200, 40);
        label_checkin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_checkin);
        
        label_checkout = new JLabel("Check in");
        label_checkout.setBounds(75, 325, 200, 40);
        label_checkout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_checkout);
        
        
        // TEXTFIELDS
        
        textfield_id = new JTextField();
        textfield_id.setBounds(170, 105, 250, 30);
        add(textfield_id);
        
        // separacion entre elementos = 45
        
        textfield_nombre = new JTextField();
        textfield_nombre.setBounds(170, 150, 250, 30);
        textfield_nombre.setEditable(false); // Deshabilitando los textfield para que no se pueda ingresar nada y evitar errores
        add(textfield_nombre);
        
        textfield_email = new JTextField();
        textfield_email.setBounds(170, 195, 250, 30);
        textfield_email.setEditable(false);
        add(textfield_email);
        
        textfield_checkin = new JTextField();
        textfield_checkin.setBounds(170, 285, 250, 30);
        textfield_checkin.setEditable(false);
        add(textfield_checkin);
        
        textfield_checkout = new JTextField();
        textfield_checkout.setBounds(170, 330, 250, 30);
        textfield_checkout.setEditable(false);
        add(textfield_checkout);
        
        textfield_habitacion = new JTextField();
        textfield_habitacion.setBounds(170, 240, 250, 30);
        textfield_habitacion.setEditable(false);
        add(textfield_habitacion);
        
        
        // BOTONES
        
        boton_buscar = new JButton("Buscar");
        boton_buscar.setBounds(140, 390, 100, 30);
        add(boton_buscar);
        
        boton_eliminar = new JButton("Eliminar");
        boton_eliminar.setBounds(280, 390, 100, 30);
        boton_eliminar.setEnabled(false); // Deshabilitando el boton para evitar errores y que solo pueda consultar al entrar
        add(boton_eliminar);
        
        
        // botón volver (<-)
        
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(40, 35, 30, 30);
        add(boton_volver);
    }
}
