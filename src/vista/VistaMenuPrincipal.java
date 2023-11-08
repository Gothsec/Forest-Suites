package vista;

import controlador.ControladorLogin;
import controlador.ControladorMenuPrincipal;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.ModeloLogin;

public class VistaMenuPrincipal extends JFrame{
    
    public JLabel label_titulo;
    public JButton boton_crear, boton_consulta, boton_actualizar, boton_eliminar, boton_listados, boton_estadisticas, boton_acerca;
    
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
        // Coordenada x = 95 porque en 100 no se veia centrado :l
        
        label_titulo = new JLabel("Forest Suites");
        label_titulo.setBounds(95, 30, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        // Distancia entre elementos = 60
        
        boton_crear = new JButton("Crear");
        boton_crear.setBounds(95, 90, 200, 40);
        add(boton_crear);
        
        boton_consulta = new JButton("Consultar");
        boton_consulta.setBounds(95, 150, 200, 40);
        add(boton_consulta);
        
        boton_actualizar = new JButton("Actualizar");
        boton_actualizar.setBounds(95, 210, 200, 40);
        add(boton_actualizar);
        
        boton_eliminar = new JButton("Eliminar");
        boton_eliminar.setBounds(95, 270, 200, 40);
        add(boton_eliminar);
        
        boton_listados = new JButton("Listados");
        boton_listados.setBounds(95, 330, 200, 40);
        add(boton_listados);
        
        boton_estadisticas = new JButton("Estadisticas");
        boton_estadisticas.setBounds(95, 390, 200, 40);
        add(boton_estadisticas);
        
        boton_acerca = new JButton("Acerca");
        boton_acerca.setBounds(95, 450, 200, 40);
        add(boton_acerca);
    }
    
    public static void main(String[] args) {
        VistaLogin vista_login = new VistaLogin();
        ModeloLogin modelo_login = new ModeloLogin();
        ControladorLogin control_login = new ControladorLogin(vista_login, modelo_login);
    }
}


