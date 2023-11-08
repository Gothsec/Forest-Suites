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
import javax.swing.*;

public class VistaLogin extends JFrame{
    
    public JTextField campo_login;
    public JPasswordField campo_contrasena;
    public JToggleButton cambio_ver;
    public JButton boton_cancelar, boton_ingresar;
    public ImageIcon imagen_ver, imagen_ocultar;
    JLabel etiqueta_titulo, etiqueta_login;
    
    public VistaLogin(){
        super("Inicio de sesion"); 
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        GUI();
        
        System.out.println("User: admin \nPassword: 123");
        
        setVisible(true);
    }
    
    public void GUI () {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("../iconos/usuario.png"));
        
        etiqueta_titulo = new JLabel("Forest-suites", imgIcon, JLabel.CENTER);
        etiqueta_titulo.setOpaque(true);
        etiqueta_titulo.setBackground(Color.WHITE);
        etiqueta_titulo.setHorizontalAlignment(JLabel.CENTER);
        etiqueta_titulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        etiqueta_titulo.setBounds(0, 0, 400, 75);
        add(etiqueta_titulo);
        
        etiqueta_login = new JLabel("Usuario");
        etiqueta_login.setHorizontalAlignment(JLabel.RIGHT);
        etiqueta_login.setBounds(10, 90, 100, 30);
        add(etiqueta_login);
        
        JLabel labelPass = new JLabel("Contraseña");
        labelPass.setBounds(10, 140, 100, 30);
        labelPass.setHorizontalAlignment(JLabel.RIGHT);
        add(labelPass);
        
        campo_login = new JTextField();
        campo_login.setBounds(120, 90, 150, 30);
        add(campo_login);
        
        campo_contrasena = new JPasswordField();
        campo_contrasena.setEchoChar('•');
        campo_contrasena.setBounds(120, 140, 150, 30);
        add(campo_contrasena);
        
        imagen_ver = new ImageIcon(getClass().getResource("../iconos/ver.png"));
        imagen_ocultar = new ImageIcon(getClass().getResource("../iconos/nover.png"));
        
        cambio_ver = new JToggleButton(imagen_ocultar); 
        cambio_ver.setBorderPainted(false);
        cambio_ver.setContentAreaFilled(false);
        cambio_ver.setFocusPainted(false);
        cambio_ver.setBounds(275, 140, 50, 30);
        add(cambio_ver);
        
        boton_cancelar = new JButton("Cancelar");
        boton_cancelar.setBounds(45, 200, 150, 35);
        boton_cancelar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        boton_cancelar.setBackground(Color.white);
        boton_cancelar.setForeground(Color.GRAY);
        add(boton_cancelar);
        
        boton_ingresar = new JButton("Ingresar");
        boton_ingresar.setBounds(205, 200, 150, 35);
        boton_ingresar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        boton_ingresar.setBackground(Color.white);
        boton_ingresar.setForeground(Color.GRAY);
        add(boton_ingresar);
    }
}