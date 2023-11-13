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
    
    public ModeloCrearUsuario objModelo;
    public VistaCrearUsuario objVista;
    public VistaMenuPrincipal obj_menu;
    
    public ControladorCrearUsuario (ModeloCrearUsuario objModelo, VistaCrearUsuario objVista) {
        this.objModelo = objModelo;
        this.objVista = objVista;
        
        objVista.boton_crear.addActionListener(new GuardarListener());
        objVista.boton_volver.addActionListener(new VolverListener());
    }
    
    class GuardarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ModeloCrearUsuario obj_crear = new ModeloCrearUsuario(objVista);
            obj_crear.nuevoUsuario();
        }
    }
    
    class VolverListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaCrear obj_vistacrear = new VistaCrear();
            ControladorCrear obj_controlador_crear = new ControladorCrear(obj_menu, obj_vistacrear);
            objVista.setVisible(false);
            objVista.dispose();
        }
    }
}
