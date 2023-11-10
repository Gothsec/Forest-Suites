package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VistaCrearUsuario extends JFrame {
    
    public JLabel label_titulo, label_nombre, label_contraseña;
    public JTextField textfield_contraseña, textfield_nombre;
    public JButton boton_crear, boton_volver;
    public ImageIcon icono_volver;
    
    public VistaCrearUsuario () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI () {
        
        label_titulo = new JLabel("Crear Usuario");
        label_titulo.setBounds(175, 30, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        label_nombre = new JLabel("Nombre");
        label_nombre.setBounds(75, 145, 200, 40);
        label_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_nombre);
        
        textfield_nombre = new JTextField();
        textfield_nombre.setBounds(170, 150, 250, 30);
        add(textfield_nombre);
        
        label_contraseña = new JLabel("Contraseña");
        label_contraseña.setBounds(75, 190, 200, 40);
        label_contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(label_contraseña);
        
        textfield_contraseña = new JTextField();
        textfield_contraseña.setBounds(170, 195, 250, 30);
        add(textfield_contraseña);
        
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(40, 35, 30, 30);
        add(boton_volver);
    }
}
