package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                
                // llamar metodo para obtener e imprimir datos
                
                /* String datos = obtenerDatos();
                
                if (datos.equals("-")) {
                    obj_utilidades.ventanaEmergente("ID no registrado en la base de datos");
                } else {
                    obj_vista_actualizar.textfield_id.setText("");
                    obj_vista_actualizar.textfield_nombre.setText("");
                    obj_vista_actualizar.textfield_email.setText("");
                    obj_vista_actualizar.combobox_habitacion.setSelectedIndex(index);
                    obj_vista_actualizar.textfield_checkin.setText("");
                    obj_vista_actualizar.textfield_checkout.setText("");
                
                    obj_vista_actualizar.textfield_id.setEnabled(false);
                
                    obj_vista_actualizar.boton_buscar.setEnabled(false);
                    obj_vista_actualizar.boton_actualizar.setEnabled(true);
                }
                
                
                
                */
            }
        });
        
        obj_vista_eliminar.boton_eliminar.addActionListener(new ActionListener() {
        
            // Al presionar el boton de eliminar se borran los datos de los campos y se cambia el estado a false,
            // se habilita el campo Id para poder buscar de nuevo
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Cliente = false; <-
                
                obj_vista_eliminar.textfield_id.setText("");
                obj_vista_eliminar.textfield_nombre.setText("");
                obj_vista_eliminar.textfield_email.setText("");
                obj_vista_eliminar.combobox_habitacion.setSelectedIndex(0);
                obj_vista_eliminar.textfield_checkin.setText("");
                obj_vista_eliminar.textfield_checkout.setText("");
                
                obj_vista_eliminar.textfield_id.setEnabled(true);
                obj_vista_eliminar.boton_buscar.setEnabled(true);
                obj_vista_eliminar.boton_eliminar.setEnabled(false);
                
                obj_utilidades.ventanaEmergente("Actualizacion exitosa");
            }
        });
        
        obj_vista_eliminar.boton_volver.addActionListener(new ActionListener() {
        
            // Vuelve al menu principal
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_eliminar.setVisible(false);
                
            }
        });
    }
    
}
