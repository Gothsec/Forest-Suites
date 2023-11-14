/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package controlador;

import conexion_base.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloCrearCliente;
import modelo.ModeloCrearUsuario;
import vista.VistaCrear;
import vista.VistaCrearCliente;
import vista.VistaCrearUsuario;
import vista.VistaMenuPrincipal;

public class ControladorCrearUsuario {
    
    public VistaCrear obj_vista_crear;
    public ModeloCrearUsuario objModelo;
    public VistaCrearUsuario objVista;
    public VistaMenuPrincipal obj_menu;
    
    public ControladorCrearUsuario (VistaCrear obj_vista_crear, VistaCrearUsuario objVista) {
        this.objVista = objVista;
        this.obj_vista_crear = obj_vista_crear;
        
        objVista.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_crear.setVisible(true);
                objVista.setVisible(false);
                objVista.dispose();
            }
        });
        
        objVista.boton_crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloCrearUsuario obj_crear = new ModeloCrearUsuario(objVista);
                obj_crear.nuevoUsuario();
            }
        });
    }
    
}
