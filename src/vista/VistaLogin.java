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
    
    public JTextField fieldLogin;
    public JPasswordField fieldPassword;
    public JToggleButton toggleVer; // para ver u ocultar el password
    public JButton buttonCancelar, buttonIngresar;
    public ImageIcon imgVer, imgOcultar;
    JLabel labelTitulo, labelLogin;
    
    public VistaLogin(){
        super("Inicio de sesion"); 
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        createGUI();
        
        System.out.println("User: admin \nPassword: 123");
        
        setVisible(true);
    }
    
    public void createGUI () {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("../imagenes/usuario.png"));
        
        labelTitulo = new JLabel("Forest-suites", imgIcon, JLabel.CENTER);
        labelTitulo.setOpaque(true);
        labelTitulo.setBackground(Color.WHITE);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelTitulo.setBounds(0, 0, 400, 75);
        add(labelTitulo);
        
        labelLogin = new JLabel("Usuario");
        labelLogin.setHorizontalAlignment(JLabel.RIGHT);
        labelLogin.setBounds(10, 90, 100, 30);
        add(labelLogin);
        
        JLabel labelPass = new JLabel("Contraseña");
        labelPass.setBounds(10, 140, 100, 30);
        labelPass.setHorizontalAlignment(JLabel.RIGHT);
        add(labelPass);
        
        fieldLogin = new JTextField();
        fieldLogin.setBounds(120, 90, 150, 30);
        add(fieldLogin);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setEchoChar('•');
        fieldPassword.setBounds(120, 140, 150, 30);
        add(fieldPassword);
        
        imgVer = new ImageIcon(getClass().getResource("../imagenes/ver.png"));
        imgOcultar = new ImageIcon(getClass().getResource("../imagenes/nover.png"));
        
        toggleVer = new JToggleButton(imgOcultar); 
        toggleVer.setBorderPainted(false);
        toggleVer.setContentAreaFilled(false);
        toggleVer.setFocusPainted(false);
        toggleVer.setBounds(275, 140, 50, 30);
        add(toggleVer);
        
        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(45, 200, 150, 35);
        add(buttonCancelar);
        
        buttonIngresar = new JButton("Ingresar");
        buttonIngresar.setBounds(205, 200, 150, 35);
        add(buttonIngresar);
    }
}