package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    obj_vista_actualizar.textfield_nombre.setEnabled(true);
                    obj_vista_actualizar.textfield_email.setEnabled(true);
                    obj_vista_actualizar.combobox_habitacion.setEnabled(true);
                    obj_vista_actualizar.textfield_checkin.setEnabled(true);
                    obj_vista_actualizar.textfield_checkout.setEnabled(true);
                
                    obj_vista_actualizar.boton_buscar.setEnabled(false);
                    obj_vista_actualizar.boton_actualizar.setEnabled(true);
                }
                
                
                
                */
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
                
                obj_vista_actualizar.textfield_id.setText("");
                obj_vista_actualizar.textfield_nombre.setText("");
                obj_vista_actualizar.textfield_email.setText("");
                obj_vista_actualizar.combobox_habitacion.setSelectedIndex(0);
                obj_vista_actualizar.textfield_checkin.setText("");
                obj_vista_actualizar.textfield_checkout.setText("");
                
                obj_vista_actualizar.textfield_id.setEnabled(true);
                obj_vista_actualizar.boton_buscar.setEnabled(true);
                obj_vista_actualizar.boton_actualizar.setEnabled(false);
                
                obj_utilidades.ventanaEmergente("Actualizacion exitosa");
            }
        });
        
        obj_vista_actualizar.boton_volver.addActionListener(new ActionListener() {
        
            // Vuelve al menu principal
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_actualizar.setVisible(false);
                
            }
        });
    }
}
