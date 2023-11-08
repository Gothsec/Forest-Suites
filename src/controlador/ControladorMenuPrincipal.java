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
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Consulta
        objVistaMenu.boton_consulta.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaConsulta objVistaConsulta = new VistaConsulta();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Actualizar
        objVistaMenu.boton_actualizar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaActualizar objVistaActualizar = new VistaActualizar();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Eliminar
        objVistaMenu.boton_eliminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEliminar objVistaEliminar = new VistaEliminar();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Listados
        objVistaMenu.boton_listados.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaListados objVistaListados = new VistaListados();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Estadisticas
        objVistaMenu.boton_estadisticas.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEstadisticas objVistaEstadisticas = new VistaEstadisticas();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Acerca
        objVistaMenu.boton_acerca.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaAcerca objVistaAcerca = new VistaAcerca();
                obj_vista_menu.setVisible(false);
            }
        });
    }
    
    
}
