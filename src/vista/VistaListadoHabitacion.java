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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;

public class VistaListadoHabitacion extends JFrame {
    
    public ImageIcon icono_volver;
    public JButton boton_volver, boton_buscar;

    public VistaListadoHabitacion() {
        setTitle("Listado de Clientes por Tipo de Habitación");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Habitación");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        // Panel para seleccionar el tipo de habitación
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Seleccionar Tipo de Habitación:");
        String[] tiposDeHabitacion = {"Suite", "Doble", "Matrimonial", "Individual"};
        JComboBox<String> comboBox = new JComboBox<>(tiposDeHabitacion);
        boton_buscar = new JButton("Buscar");
        
                
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(20, 520, 30, 30);

        panel.add(label);
        panel.add(comboBox);
        panel.add(boton_buscar);
        panel.add(boton_volver);

        // Ajustar la posición y tamaño del JTable
        JScrollPane scrollPane = new JScrollPane(table);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(panel)
                .addComponent(scrollPane)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPane)
        );

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaListadoHabitacion();
        });
    }
}