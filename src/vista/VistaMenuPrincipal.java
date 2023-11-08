package vista;

import controlador.ControladorMenuPrincipal;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaMenuPrincipal extends JFrame{
    
    public JLabel labelTitulo;
    public JButton botonCrear, botonConsulta, botonActualizar, botonEliminar, botonListados, botonEstadisticas, botonAcerca;
    
    public VistaMenuPrincipal () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI() {
        labelTitulo = new JLabel("Forest Suites");
        labelTitulo.setBounds(95, 30, 200, 40);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(labelTitulo);
        
        // Distancia entre elementos = 60
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(95, 90, 200, 40);
        add(botonCrear);
        
        botonConsulta = new JButton("Consultar");
        botonConsulta.setBounds(95, 150, 200, 40);
        add(botonConsulta);
        
        botonActualizar = new JButton("Actualizar");
        botonActualizar.setBounds(95, 210, 200, 40);
        add(botonActualizar);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(95, 270, 200, 40);
        add(botonEliminar);
        
        botonListados = new JButton("Listados");
        botonListados.setBounds(95, 330, 200, 40);
        add(botonListados);
        
        botonEstadisticas = new JButton("Estadisticas");
        botonEstadisticas.setBounds(95, 390, 200, 40);
        add(botonEstadisticas);
        
        botonAcerca = new JButton("Acerca");
        botonAcerca.setBounds(95, 450, 200, 40);
        add(botonAcerca);
    }
    
    public static void main(String[] args) {
        VistaMenuPrincipal objVistaMenu = new VistaMenuPrincipal();
        ControladorMenuPrincipal objControladorMenu = new ControladorMenuPrincipal(objVistaMenu);
    }
}


