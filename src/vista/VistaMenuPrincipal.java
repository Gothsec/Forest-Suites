package vista;

import controlador.ControladorLogin;
import controlador.ControladorMenuPrincipal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.ModeloLogin;

public class VistaMenuPrincipal extends JFrame{
    
    public JLabel label_titulo;
    public JButton boton_usuario, boton_crear, boton_consulta, boton_actualizar, boton_eliminar, boton_listados, boton_estadisticas, boton_acerca;
    public ImageIcon icono_usuario;
    
    public VistaMenuPrincipal () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI() {
        // Coordenada x = 95 porque en 100 no se veia centrado :l
        
        label_titulo = new JLabel("Forest Suites");
        label_titulo.setBounds(95, 60, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        // Distancia entre elementos = 60
       
        
        icono_usuario = new ImageIcon(getClass().getResource("../iconos/salir.png"));
        boton_usuario = new JButton(icono_usuario);
        boton_usuario.setBackground(Color.WHITE);
        boton_usuario.setForeground(Color.white);
        boton_usuario.setBounds(10, 10, 40, 40);
        boton_usuario.setBorderPainted(false);
        boton_usuario.setOpaque(false);
        boton_usuario.setFocusPainted(false);
        boton_usuario.setBorder(BorderFactory.createEmptyBorder());
        add(boton_usuario);
        
        boton_crear = new JButton("Crear");
        boton_crear.setBackground(Color.darkGray);
        boton_crear.setForeground(Color.white);
        boton_crear.setBounds(95, 140, 200, 40);
        add(boton_crear);
        
        boton_consulta = new JButton("Consultar");
        boton_consulta.setBackground(Color.darkGray);
        boton_consulta.setForeground(Color.white);
        boton_consulta.setBounds(95, 200, 200, 40);
        add(boton_consulta);
        
        boton_actualizar = new JButton("Actualizar");
        boton_actualizar.setBackground(Color.darkGray);
        boton_actualizar.setForeground(Color.white);
        boton_actualizar.setBounds(95, 260, 200, 40);
        add(boton_actualizar);
        
        boton_eliminar = new JButton("Eliminar");
        boton_eliminar.setBackground(Color.darkGray);
        boton_eliminar.setForeground(Color.white);
        boton_eliminar.setBounds(95, 320, 200, 40);
        add(boton_eliminar);
        
        boton_listados = new JButton("Listados");
        boton_listados.setBackground(Color.darkGray);
        boton_listados.setForeground(Color.white);
        boton_listados.setBounds(95, 380, 200, 40);
        add(boton_listados);
        
        boton_estadisticas = new JButton("Estadisticas");
        boton_estadisticas.setBackground(Color.darkGray);
        boton_estadisticas.setForeground(Color.white);
        boton_estadisticas.setBounds(95, 440, 200, 40);
        add(boton_estadisticas);
        
        boton_acerca = new JButton("Acerca");
        boton_acerca.setBackground(Color.darkGray);
        boton_acerca.setForeground(Color.white);
        boton_acerca.setBounds(95, 500, 200, 40);
        add(boton_acerca);       
    }
    
    public static void main(String[] args) {
        VistaLogin vista_login = new VistaLogin();
        ModeloLogin modelo_login = new ModeloLogin(vista_login);
        ControladorLogin control_login = new ControladorLogin(vista_login, modelo_login);
    }
}


