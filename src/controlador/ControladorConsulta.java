package controlador;

import Utilidades.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaConsulta;
import vista.VistaMenuPrincipal;
import conexion_base.Conexion;
import javax.swing.JOptionPane;
import modelo.ModeloConsulta;

public class ControladorConsulta {
    
    VistaMenuPrincipal obj_menu;
    VistaConsulta obj_vista_consulta;
    Utilidades obj_utilidades = new Utilidades();
    
    public ControladorConsulta (VistaMenuPrincipal obj_menu, VistaConsulta obj_vista_consulta) {
        this.obj_menu = obj_menu;
        this.obj_vista_consulta = obj_vista_consulta;
        
        obj_vista_consulta.boton_consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloConsulta obj_modelo = new ModeloConsulta(obj_vista_consulta);
                obj_modelo.consultarReservacion();
            }
        });
        
        obj_vista_consulta.boton_limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_consulta.textfield_id.setText("");
                obj_vista_consulta.textfield_nombre.setText("");
                obj_vista_consulta.textfield_email.setText("");
                obj_vista_consulta.textfield_habitacion.setText("");
                obj_vista_consulta.textfield_checkin.setText("");
                obj_vista_consulta.textfield_checkout.setText("");
                
                obj_vista_consulta.textfield_id.setEditable(true);
                obj_vista_consulta.boton_consultar.setEnabled(true);
                obj_vista_consulta.boton_limpiar.setEnabled(false);
            }
        });
        
        obj_vista_consulta.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_menu.setVisible(true);
                obj_vista_consulta.setVisible(false);
                obj_vista_consulta.dispose();
            }
        });
    }
}
