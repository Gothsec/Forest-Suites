package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaAcerca;
import vista.VistaActualizar;
import vista.VistaConsulta;
import vista.VistaCrear;
import vista.VistaEliminar;
import vista.VistaEstadisticas;
import vista.VistaListados;
import vista.VistaMenuPrincipal;

public class ControladorMenuPrincipal {
    
    VistaMenuPrincipal obj_vista_menu;
    
    public ControladorMenuPrincipal (VistaMenuPrincipal obj_vista_menu) {
        this.obj_vista_menu = obj_vista_menu;
        
        // Acceder a Crear
        obj_vista_menu.boton_crear.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaCrear obj_vista_crear = new VistaCrear();
                ControladorCrear obj_crear = new ControladorCrear(obj_vista_menu, obj_vista_crear);
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Consulta
        obj_vista_menu.boton_consulta.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_menu.setVisible(false);
                VistaConsulta obj_vista_consulta = new VistaConsulta();
                ControladorConsulta obj_controlador_consulta = new ControladorConsulta(obj_vista_menu, obj_vista_consulta);
            }
        });
        
        // Acceder a Actualizar
        obj_vista_menu.boton_actualizar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaActualizar obj_vista_actualizar = new VistaActualizar();
                ControladorActualizar obj_controlador_actualizar = new ControladorActualizar(obj_vista_menu, obj_vista_actualizar);
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Eliminar
        obj_vista_menu.boton_eliminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaEliminar obj_vista_eliminar = new VistaEliminar();
                ControladorEliminar obj_controlador_eliminar = new ControladorEliminar(obj_vista_menu, obj_vista_eliminar);
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Listados
        obj_vista_menu.boton_listados.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaListados obj_vista_listados = new VistaListados();
                ControladorListados obj_controladorlist = new ControladorListados(obj_vista_listados);
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Estadisticas
        obj_vista_menu.boton_estadisticas.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaEstadisticas obj_vista_estadisticas = new VistaEstadisticas();
                ControladorEstadisticas obj_controlador_est = new ControladorEstadisticas(obj_vista_estadisticas);
                obj_vista_menu.setVisible(false);
            }
        });
        
        // Acceder a Acerca
        obj_vista_menu.boton_acerca.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaAcerca obj_vista_acerca = new VistaAcerca();
                ControladorAcerca obj_controlador_acerca = new ControladorAcerca(obj_vista_menu, obj_vista_acerca);
                obj_vista_menu.setVisible(false);
            }
        });
    }
    
    
}
