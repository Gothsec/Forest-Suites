/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloCrearCliente;
import modelo.ModeloCrearUsuario;
import vista.VistaCrear;
import vista.VistaCrearCliente;
import vista.VistaCrearUsuario;
import vista.VistaMenuPrincipal;

public class ControladorCrear {
    
    ModeloCrearCliente obj_modelocliente;
    ModeloCrearUsuario obj_modelousuario;
    VistaMenuPrincipal obj_menu;
    VistaCrear obj_vista_crear;
    VistaCrearCliente obj_vista_crearcliente;
    VistaCrearUsuario obj_vista_crearusuario;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorCrear (VistaMenuPrincipal obj_menu, VistaCrear obj_vista_crear) {
        this.obj_menu = obj_menu;
        this.obj_vista_crear= obj_vista_crear;
        
        
        obj_vista_crear.boton_crear_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_crearcliente = new VistaCrearCliente(obj_menu);
                ControladorCrearCliente obj_controlador_crearcliente = new ControladorCrearCliente(obj_vista_crear, obj_vista_crearcliente);
                obj_vista_crear.setVisible(false);
            }
        });
        
        obj_vista_crear.boton_crear_usuario.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_crearusuario = new VistaCrearUsuario();
                ControladorCrearUsuario obj_controlador_crearusuario = new ControladorCrearUsuario(obj_vista_crear, obj_vista_crearusuario);
                obj_vista_crear.setVisible(false);
            }
        });
        
        obj_vista_crear.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaMenuPrincipal obj_vistamenu = new VistaMenuPrincipal();
                ControladorMenuPrincipal obj_controladormenu = new ControladorMenuPrincipal(obj_vistamenu);
                obj_vista_crear.setVisible(false);
                obj_vista_crear.dispose();
                
            }
        });
    }
    
}
