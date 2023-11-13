package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloActualizar;
import vista.VistaActualizar;
import vista.VistaMenuPrincipal;

public class ControladorActualizar {
    VistaMenuPrincipal obj_menu;
    VistaActualizar obj_vista_actualizar;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorActualizar (VistaMenuPrincipal obj_menu, VistaActualizar obj_vista_actualizar) {
        this.obj_menu = obj_menu;
        this.obj_vista_actualizar = obj_vista_actualizar;
        
        
        obj_vista_actualizar.boton_buscar.addActionListener(new ActionListener() {
        
            // Si se encuentra el id, se deshabilita el campo id y aparecen los datos con los campos habilitados para editar
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ModeloActualizar obj_modelo = new ModeloActualizar(obj_vista_actualizar);
                obj_modelo.escribirReservacion();
     
            }
        });
        
        obj_vista_actualizar.boton_actualizar.addActionListener(new ActionListener() {
        
            // Al presionar el boton de actualizar se actualizan y se borran los datos de los campos, se habilita el campo Id para poder buscar de nuevo
            // Se verifican los datos antes de actualizar para evitar errores.
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // se llama al metodo para validar los datos
                // si son correctos se llama al metodo que actualiza los datos
                // si no, se muestra una ventana emergente y no actualiza, queda con los campos como se dejaron antes de presionar el boton
                
                ModeloActualizar obj_modelo = new ModeloActualizar(obj_vista_actualizar);
                obj_modelo.actualizarReservacion();
            }
        });
        
        obj_vista_actualizar.boton_volver.addActionListener(new ActionListener() {
        
            // Vuelve al menu principal
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_actualizar.setVisible(false);
                obj_vista_actualizar.dispose();
            }
        });
    }
}
