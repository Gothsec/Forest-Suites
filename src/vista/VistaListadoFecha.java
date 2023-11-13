package vista;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaListadoFecha extends JFrame {

    public JTextField textfield1;
    public JComboBox<String> comboBox;
    public JComboBox<String> tipoFechaCombo;
    public JButton boton_volver;
    public ImageIcon icono_volver;

    public VistaListadoFecha() {
        setTitle("Listado de Clientes por Tipo de Fecha");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);

        GroupLayout.SequentialGroup horizontalGroup = layout.createSequentialGroup();
        horizontalGroup.addComponent(tipoFechaLabel)
                      .addComponent(tipoFechaCombo)
                      .addComponent(fechaLabel)
                      .addComponent(textfield1)
                      .addComponent(buscarButton)
                      .addComponent(boton_volver);
        layout.setHorizontalGroup(horizontalGroup);

        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tipoFechaLabel)
                        .addComponent(tipoFechaCombo)
                        .addComponent(fechaLabel)
                        .addComponent(textfield1)
                        .addComponent(buscarButton)
                        .addComponent(boton_volver));
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaListadoFecha();
        });
    }
}
