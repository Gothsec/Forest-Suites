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
import vista.VistaGraficoTorta;
import vista.VistaMenuPrincipal;

public class ControladorGraficoTorta {
    
    VistaMenuPrincipal obj_menu;
    VistaGraficoTorta obj_vista_graficos;
    
    public ControladorGraficoTorta (VistaGraficoTorta obj_vista_graficos) {
        this.obj_menu = obj_menu;
        this.obj_vista_graficos= obj_vista_graficos;

        
        obj_vista_graficos.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaEstadisticas obj_vista_est = new VistaEstadisticas();
                ControladorEstadisticas obj_controlador_est = new ControladorEstadisticas(obj_vista_est);
                obj_vista_graficos.setVisible(false);
                
            }
        });
    }
    
}
