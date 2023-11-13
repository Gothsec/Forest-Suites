/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaListadoFecha extends JFrame {
    public JTextField textfield1;
    public JComboBox<String> comboBox;
    public JComboBox<String> tipoFechaCombo;

    public VistaListadoFecha() {
        setTitle("Listado de Clientes por Tipo de Fecha");
        setSize(1000, 500);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Habitación");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        // Panel para seleccionar el tipo de fecha y la fecha
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        JLabel tipoFechaLabel = new JLabel("Seleccionar Tipo de Fecha:");
        tipoFechaCombo = new JComboBox<>(new String[]{"Check-in", "Check-out"});

        JLabel fechaLabel = new JLabel("Fecha:");
        textfield1 = new JTextField();

        JButton buscarButton = new JButton("Buscar");

        GroupLayout.SequentialGroup horizontalGroup = layout.createSequentialGroup();
        horizontalGroup.addComponent(tipoFechaLabel).addComponent(tipoFechaCombo).addComponent(fechaLabel).addComponent(textfield1).addComponent(buscarButton);
        layout.setHorizontalGroup(horizontalGroup);

        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tipoFechaLabel).addComponent(tipoFechaCombo).addComponent(fechaLabel).addComponent(textfield1).addComponent(buscarButton));
        layout.setVerticalGroup(verticalGroup);

        // Ajustar la posición y tamaño del JTable
        JScrollPane scrollPane = new JScrollPane(table);

        GroupLayout mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);
        mainLayout.setAutoCreateContainerGaps(true);
        mainLayout.setAutoCreateGaps(true);

        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup()
                        .addComponent(panel)
                        .addComponent(scrollPane)
        );

        mainLayout.setVerticalGroup(
                mainLayout.createSequentialGroup()
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane)
        );

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaListadoFecha();
        });
    }
}