package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenuPrincipal;

public class ControladorMenuPrincipal {
    
    VistaMenuPrincipal objVistaMenu;
    
    public ControladorMenuPrincipal (VistaMenuPrincipal objVistaMenu) {
        this.objVistaMenu = objVistaMenu;
        
        // Crear
        objVistaMenu.botonCrear.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaCrear objVistaCrear = new VistaCrear();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Consulta
        objVistaMenu.botonConsulta.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaConsulta objVistaConsulta = new VistaConsulta();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Actualizar
        objVistaMenu.botonActualizar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaActualizar objVistaActualizar = new VistaActualizar();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Eliminar
        objVistaMenu.botonEliminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEliminar objVistaEliminar = new VistaEliminar();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Listados
        objVistaMenu.botonListados.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaListados objVistaListados = new VistaListados();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Estadisticas
        objVistaMenu.botonEstadisticas.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaEstadisticas objVistaEstadisticas = new VistaEstadisticas();
                objVistaMenu.setVisible(false);
            }
        });
        
        // Acerca
        objVistaMenu.botonAcerca.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // VistaAcerca objVistaAcerca = new VistaAcerca();
                objVistaMenu.setVisible(false);
            }
        });
    }
    
    
}
