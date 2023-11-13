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

public class VistaListados extends JFrame{
    
    public JButton btnListadoGeneral, btnListadoHabitacion, btnListadoFecha, boton_volver;
    public ImageIcon icono_volver;
    public JLabel label_titulo;
    
    public VistaListados(){
        setTitle("Menú de Listados");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        
        label_titulo = new JLabel("Listados");
        label_titulo.setBounds(130, 25, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(20, 20, 30, 30);
        add(boton_volver);

        btnListadoGeneral = new JButton("Listado General");
        btnListadoGeneral.setBounds(100, 80, 200, 40);
        add(btnListadoGeneral);

        btnListadoHabitacion = new JButton("Listado por Habitacion");
        btnListadoHabitacion.setBounds(100, 140, 200, 40);
        add(btnListadoHabitacion);

        btnListadoFecha = new JButton("Listado por fecha");
        btnListadoFecha.setBounds(100, 200, 200, 40);
        add(btnListadoFecha);
        
    }

}