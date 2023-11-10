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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VistaCrear extends JFrame {
    
    public JLabel label_titulo;
    public JButton boton_crear_cliente, boton_crear_usuario, boton_volver;
    public ImageIcon icono_volver;
    
    public VistaCrear () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI () {
        
        // LABELS
        label_titulo = new JLabel("Crear");
        label_titulo.setBounds(155, 35, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        // botón volver (<-)
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(40, 35, 30, 30);
        add(boton_volver);
        
        boton_crear_cliente = new JButton("Crear cliente");
        boton_crear_cliente.setBounds(110, 130, 180,40);
        add(boton_crear_cliente);
        
        boton_crear_usuario = new JButton("Crear usuario");
        boton_crear_usuario.setBounds(110, 210, 180,40);
        add(boton_crear_usuario);
    }
}
