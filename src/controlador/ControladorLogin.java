package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;
import vista.VistaCrear;
import vista.VistaLogin;
import vista.VistaMenuPrincipal;

public class ControladorLogin {
    public VistaLogin objeto_vista;
    public ControladorMenuPrincipal obj_controlador;
    public ModeloLogin modelo_login;
    
    
    public ControladorLogin(VistaLogin objeto_vista, ModeloLogin modelo_login) {
        this.objeto_vista = objeto_vista;
        this.modelo_login = modelo_login;
        
        objeto_vista.boton_cancelar.addActionListener(new CancelarListener());
        objeto_vista.campo_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objeto_vista.campo_contrasena.requestFocus();
            }
        });
   
        
        objeto_vista.boton_ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloLogin obj_modelo = new ModeloLogin(objeto_vista);
                String[] entrar = obj_modelo.verificar();
                if (entrar != null) {
                    objeto_vista.setVisible(false);
                    objeto_vista.dispose();
                    VistaMenuPrincipal obj_vista_menu = new VistaMenuPrincipal();
                    ControladorMenuPrincipal obj_control = new ControladorMenuPrincipal(obj_vista_menu);
                    
                    if (entrar[2].equals("Recepcionista")) {
                        obj_vista_menu.boton_eliminar.setEnabled(false);
                    }
                    
                    if (entrar[2].equals("Empleado")) {
                        obj_vista_menu.boton_eliminar.setEnabled(false);
                        obj_vista_menu.boton_crear.setEnabled(false);
                        obj_vista_menu.boton_actualizar.setEnabled(false);
                    }
                    
                    obj_vista_menu.setVisible(true);
                } else {
                    Utilidades obj_util = new Utilidades();
                    obj_util.ventanaEmergente("Usuario no registrado");
                }
            }
        });
        // Agregar el controlador al JToggleButton cambio_ver
        objeto_vista.cambio_ver.addActionListener(new ToggleButtonListener());
    }
    
    
    
    class CancelarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            objeto_vista.dispose();
            System.exit(0);
        }
    }
    
    class ToggleButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (objeto_vista.cambio_ver.isSelected()) {
                objeto_vista.cambio_ver.setIcon(objeto_vista.imagen_ver); // Cambia a la imagen "imagen_ver"
                objeto_vista.campo_contrasena.setEchoChar((char) 0); // Mostrar contraseña
            } else {
                objeto_vista.cambio_ver.setIcon(objeto_vista.imagen_ocultar); // Cambia a la imagen "imagen_ocultar"
                objeto_vista.campo_contrasena.setEchoChar('•'); // Ocultar contraseña
            }
        }
    }


    /*public void evento_validar() {
        String login = objeto_vista.campo_login.getText();
        char caracteres[] = objeto_vista.campo_contrasena.getPassword();
        String passw = String.valueOf(caracteres);

        if (login.equals
        ("") || passw.equals("")) {
            JOptionPane.showMessageDialog(objeto_vista, "Login y/o password no pueden ser vacíos");
        } else {
            if (login.equals("admin") && passw.equals("123")) {
                objeto_vista.setVisible(false);
                objeto_vista.dispose();
                VistaMenuPrincipal obj_vista_menu = new VistaMenuPrincipal();
                ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(obj_vista_menu);
                obj_vista_menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(objeto_vista, "Ingreso incorrecto. Login y/o password incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }*/
}
