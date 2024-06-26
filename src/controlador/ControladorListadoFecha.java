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
import modelo.ModeloListadoFecha;
import vista.VistaListadoFecha;
import vista.VistaListados;
import vista.VistaMenuPrincipal;

public class ControladorListadoFecha {
    VistaMenuPrincipal obj_vista_menu;
    VistaListadoFecha obj_vista_graficos;
    
    public ControladorListadoFecha (VistaMenuPrincipal obj_vista_menu,VistaListadoFecha obj_vista_graficos) {
        this.obj_vista_menu = obj_vista_menu;
        this.obj_vista_graficos= obj_vista_graficos;

        obj_vista_graficos.buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListadoFecha obj_modelo = new ModeloListadoFecha(obj_vista_graficos);
                obj_modelo.obtenerDatos();
            }
        });

        obj_vista_graficos.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaListados obj_vista_est = new VistaListados();
                ControladorListados obj_controlador_est = new ControladorListados(obj_vista_menu,obj_vista_est);
                obj_vista_graficos.setVisible(false);
                obj_vista_graficos.dispose();
            }
        });
    }
    
}
