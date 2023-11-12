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
import vista.VistaCrear;
import vista.VistaCrearCliente;
import vista.VistaEstadisticas;
import vista.VistaGraficoBarras;
import vista.VistaGraficoLineas;
import vista.VistaGraficoTorta;
import vista.VistaMenuPrincipal;

public class ControladorEstadisticas {
    
    VistaMenuPrincipal obj_menu;
    VistaEstadisticas obj_vista_graficos;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorEstadisticas (VistaMenuPrincipal obj_menu, VistaEstadisticas obj_vista_graficos) {
        this.obj_menu = obj_menu;
        this.obj_vista_graficos= obj_vista_graficos;
        
        
        obj_vista_graficos.boton_barras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaGraficoBarras obj_vista_barras = new VistaGraficoBarras();
                obj_vista_graficos.setVisible(false);
            }
        });
        
        obj_vista_graficos.boton_lineas.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaGraficoLineas obj_vista_lineas = new VistaGraficoLineas();
                obj_vista_graficos.setVisible(false);
            }
        });
        
        obj_vista_graficos.boton_torta.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaGraficoTorta obj_vista_torta = new VistaGraficoTorta();
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
