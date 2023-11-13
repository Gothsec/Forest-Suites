package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaListadoGeneral extends JFrame {

    public JButton boton_volver;
    public ImageIcon icono_volver;

    public VistaListadoGeneral() {
        setTitle("Listado General de Clientes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

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

        // Crear un JPanel para contener el botón y el JScrollPane
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);

        // Agregar el botón al panel en la esquina superior izquierda
        panelPrincipal.add(boton_volver, BorderLayout.WEST); // Usa BorderLayout.WEST en lugar de BorderLayout.NORTH
        // Agregar el JScrollPane al panel principal
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel principal al JFrame
        getContentPane().add(panelPrincipal);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaListadoGeneral();
        });
    }
}
