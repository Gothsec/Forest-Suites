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
import vista.VistaEstadisticas;
import vista.VistaListadoFecha;
import vista.VistaListadoGeneral;
import vista.VistaListadoHabitacion;
import vista.VistaMenuPrincipal;
import vista.VistaListados;

public class ControladorListados {
    
    VistaMenuPrincipal obj_menu;
    VistaListados obj_vista_graficos;
    
    public ControladorListados (VistaListados obj_vista_graficos) {
        this.obj_menu = obj_menu;
        this.obj_vista_graficos= obj_vista_graficos;

        obj_vista_graficos.btnListadoGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaListadoGeneral obj_general = new VistaListadoGeneral();
                ControladorListadoGeneral obj_gen = new ControladorListadoGeneral(obj_general);
                obj_general.setVisible(true);
                obj_vista_graficos.setVisible(false);
            }
        });

        obj_vista_graficos.btnListadoHabitacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              VistaListadoHabitacion obj_habitacion = new VistaListadoHabitacion();
              ControladorListadoHabitacion obj_hab = new ControladorListadoHabitacion(obj_habitacion);
              obj_habitacion.setVisible(true);
              obj_vista_graficos.setVisible(false);
            }
        });

        obj_vista_graficos.btnListadoFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaListadoFecha obj_vistafecha = new VistaListadoFecha();
                ControladorListadoFecha obj_fecha = new ControladorListadoFecha(obj_vistafecha);
                obj_vista_graficos.setVisible(false);
            }
        });
        
        obj_vista_graficos.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaMenuPrincipal obj_vistamenu = new VistaMenuPrincipal();
                ControladorMenuPrincipal obj_controladormenu = new ControladorMenuPrincipal(obj_vistamenu);
                obj_vista_graficos.setVisible(false);
                
            }
        });
    }
    
}
