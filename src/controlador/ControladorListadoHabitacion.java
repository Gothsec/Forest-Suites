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
import modelo.ModeloListadoHabitacion;
import vista.VistaListadoHabitacion;
import vista.VistaListados;
import vista.VistaMenuPrincipal;

public class ControladorListadoHabitacion {
    
    VistaMenuPrincipal obj_menu;
    VistaListadoHabitacion obj_vista_graficos;
    
    public ControladorListadoHabitacion (VistaListadoHabitacion obj_vista_graficos) {
        this.obj_menu = obj_menu;
        this.obj_vista_graficos= obj_vista_graficos;
        
        obj_vista_graficos.boton_buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListadoHabitacion obj_habitacion = new ModeloListadoHabitacion(obj_vista_graficos);
                obj_habitacion.obtenerDatos();
            }
        });


        obj_vista_graficos.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaListados obj_vista_est = new VistaListados();
                ControladorListados obj_controlador_est = new ControladorListados(obj_vista_est);
                obj_vista_graficos.setVisible(false);
                obj_vista_graficos.dispose();
            }
        });
    }
    
}
