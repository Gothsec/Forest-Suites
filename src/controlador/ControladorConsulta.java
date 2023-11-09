package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaConsulta;
import vista.VistaMenuPrincipal;

public class ControladorConsulta {
    
    VistaMenuPrincipal obj_menu;
    VistaConsulta obj_vista_consulta;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorConsulta (VistaMenuPrincipal obj_menu, VistaConsulta obj_vista_consulta) {
        this.obj_menu = obj_menu;
        this.obj_vista_consulta = obj_vista_consulta;
        
        
        /*
            Hay 2 posibles acciones:
            
                1- consultar el id, si lo encuentra solo te muestra los datos, si no, aparece una ventana indicando que no esta registrado
                2- limpiar los datos de la ultima consulta, debes limpiar los datos para poder volver a buscar, si no, no se habilita el campo id
            
                Se realizó de esta manera para limitar la cantidad de acciones que el usuario puede hacer y así evitar errores
            
        */
        
        
        obj_vista_consulta.boton_consultar.addActionListener(new ActionListener() {
        
            // Se deshabilita el id y aparecen los datos
            
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
                
                    obj_vista_actualizar.boton_buscar.setEnabled(false);
                    obj_vista_actualizar.boton_actualizar.setEnabled(true);
                }*/
                
                
            }
        });
        
        obj_vista_consulta.boton_limpiar.addActionListener(new ActionListener() {
        
            // Se borran los datos y se habilita el campo Id
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_consulta.textfield_id.setText("");
                obj_vista_consulta.textfield_nombre.setText("");
                obj_vista_consulta.textfield_email.setText("");
                obj_vista_consulta.textfield_habitacion.setText("");
                obj_vista_consulta.textfield_checkin.setText("");
                obj_vista_consulta.textfield_checkout.setText("");
                
                obj_vista_consulta.textfield_id.setEnabled(true);
                obj_vista_consulta.boton_consultar.setEnabled(true);
                obj_vista_consulta.boton_limpiar.setEnabled(false);
            }
        });
        
        obj_vista_consulta.boton_volver.addActionListener(new ActionListener() {
        
            // Vuelve al menu principal
            
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_consulta.setVisible(false);
                
            }
        });
    }
}
