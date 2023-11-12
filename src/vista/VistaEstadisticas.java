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

public class VistaEstadisticas extends JFrame {
    
    public JLabel label_titulo;
    public JButton boton_barras, boton_lineas, boton_torta, boton_volver;
    public ImageIcon icono_volver;
    
    public VistaEstadisticas () {
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
        label_titulo = new JLabel("Estadisticas");
        label_titulo.setBounds(110, 35, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        // botón volver (<-)
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(40, 35, 30, 30);
        add(boton_volver);
        
        boton_barras = new JButton("Grafico de barras");
        boton_barras.setBounds(100, 130, 200,40);
        add(boton_barras);
        
        boton_lineas = new JButton("Grafico de lineas");
        boton_lineas.setBounds(100, 200, 200,40);
        add(boton_lineas);
        
        boton_torta = new JButton("Grafico de torta");
        boton_torta.setBounds(100, 270, 200,40);
        add(boton_torta);
    }
}
