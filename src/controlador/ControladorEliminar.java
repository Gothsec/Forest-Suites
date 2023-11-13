package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloEliminar;
import vista.VistaEliminar;
import vista.VistaMenuPrincipal;

public class ControladorEliminar {
    
    VistaMenuPrincipal obj_menu;
    VistaEliminar obj_vista_eliminar;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorEliminar (VistaMenuPrincipal obj_menu, VistaEliminar obj_vista_eliminar) {
        this.obj_menu = obj_menu;
        this.obj_vista_eliminar = obj_vista_eliminar;
        
        
        obj_vista_eliminar.boton_buscar.addActionListener(new ActionListener() {
        
            // Si se encuentra el id, se deshabilita el campo id y aparecen los datos con los campos inhabilitados
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ModeloEliminar obj_eliminar = new ModeloEliminar(obj_vista_eliminar);
                obj_eliminar.escribirReservacion();
            }
        });
        
        obj_vista_eliminar.boton_eliminar.addActionListener(new ActionListener() {
        
            // Al presionar el boton de eliminar se borran los datos de los campos y se cambia el estado a false,
            // se habilita el campo Id para poder buscar de nuevo
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ModeloEliminar obj_eliminar = new ModeloEliminar(obj_vista_eliminar);
                obj_eliminar.EliminarReservacion();
            }
        });
        
        obj_vista_eliminar.boton_volver.addActionListener(new ActionListener() {
        
            // Vuelve al menu principal
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_eliminar.setVisible(false);
                obj_vista_eliminar.dispose();
                
            }
        });
    }
    
}
