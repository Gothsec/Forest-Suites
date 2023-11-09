package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaAcerca;
import vista.VistaMenuPrincipal;

public class ControladorAcerca {
    
    VistaMenuPrincipal obj_vista_menu;
    VistaAcerca obj_vista_acerca;
    
    public ControladorAcerca (VistaMenuPrincipal obj_vista_menu, VistaAcerca obj_vista_acerca) {
        this.obj_vista_menu = obj_vista_menu;
        this.obj_vista_acerca = obj_vista_acerca;
        
        // Volver al menu
        obj_vista_acerca.boton_volver.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_menu.setVisible(true);
                obj_vista_acerca.setVisible(false);                
            }
        });
    }
}
