package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenuPrincipal;

public class ControladorMenuPrincipal {
    
    VistaMenuPrincipal obj_vista_menu;
    
    public ControladorMenuPrincipal (VistaMenuPrincipal objVistaMenu) {
        this.obj_vista_menu = obj_vista_menu;
        
        // Acceder a Crear
        objVistaMenu.boton_crear.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaCrear objVistaCrear = new VistaCrear();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Consulta
        objVistaMenu.boton_consulta.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaConsulta objVistaConsulta = new VistaConsulta();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Actualizar
        objVistaMenu.boton_actualizar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaActualizar objVistaActualizar = new VistaActualizar();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Eliminar
        objVistaMenu.boton_eliminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEliminar objVistaEliminar = new VistaEliminar();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Listados
        objVistaMenu.boton_listados.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaListados objVistaListados = new VistaListados();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Estadisticas
        objVistaMenu.boton_estadisticas.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEstadisticas objVistaEstadisticas = new VistaEstadisticas();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acceder a Acerca
        objVistaMenu.boton_acerca.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaAcerca objVistaAcerca = new VistaAcerca();
                objVistaMenu.setVisible(false);
            }
        });
    }
    
    
}
