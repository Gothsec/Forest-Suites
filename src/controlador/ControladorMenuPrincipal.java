package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaConsulta;
import vista.VistaMenuPrincipal;

public class ControladorMenuPrincipal {
    
    VistaMenuPrincipal obj_vista_menu;
    
    public ControladorMenuPrincipal (VistaMenuPrincipal obj_vista_menu) {
        this.obj_vista_menu = obj_vista_menu;
        
        // Acceder a Crear
        obj_vista_menu.boton_crear.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaCrear objVistaCrear = new VistaCrear();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Consulta
        obj_vista_menu.boton_consulta.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_menu.setVisible(false);
                VistaConsulta obj_vista_onsulta = new VistaConsulta();
            }
        });
        
        // Acceder a Actualizar
        obj_vista_menu.boton_actualizar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaActualizar objVistaActualizar = new VistaActualizar();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Eliminar
        obj_vista_menu.boton_eliminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEliminar objVistaEliminar = new VistaEliminar();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Listados
        obj_vista_menu.boton_listados.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaListados objVistaListados = new VistaListados();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Estadisticas
        obj_vista_menu.boton_estadisticas.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEstadisticas objVistaEstadisticas = new VistaEstadisticas();
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Acerca
        obj_vista_menu.boton_acerca.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaAcerca objVistaAcerca = new VistaAcerca();
                obj_vista_menu.setVisible(false);
            }
        });
    }
    
    
}
