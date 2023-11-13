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

public class VistaListadoGeneral extends JFrame {

    public VistaListadoGeneral() {
        setTitle("Listado General de Clientes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Habitación");
        model.addColumn("Correo");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        table.setDefaultEditor(Object.class, null);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaListadoGeneral();
        });
    }
}