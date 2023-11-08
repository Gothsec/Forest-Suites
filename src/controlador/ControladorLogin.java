/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;
import vista.VistaLogin;
import vista.VistaMenuPrincipal;

public class ControladorLogin {
    public VistaLogin objeto_vista;
    public ControladorMenuPrincipal obj_controlador;

    public ControladorLogin(VistaLogin objeto_vista, ModeloLogin modelo_login) {
        this.objeto_vista = objeto_vista;
        objeto_vista.boton_ingresar.addActionListener(new IngresarListener());
        objeto_vista.campo_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objeto_vista.campo_contrasena.requestFocus();
            }
        });
        objeto_vista.campo_contrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_validar();
            }
        });
    }
    

    class IngresarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            evento_validar();
        }
    }

    public void evento_validar() {
        String login = objeto_vista.campo_login.getText();
        char caracteres[] = objeto_vista.campo_contrasena.getPassword();
        String passw = String.valueOf(caracteres);
        

        if (login.equals("") || passw.equals("")) {
            JOptionPane.showMessageDialog(objeto_vista, "Login y/o password no pueden ser vacíos");
        } else {
            if (login.equals("admin") && passw.equals("123")) {
                objeto_vista.setVisible(false);
                new VistaMenuPrincipal().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(objeto_vista, "Ingreso incorrecto. Login y/o password incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}