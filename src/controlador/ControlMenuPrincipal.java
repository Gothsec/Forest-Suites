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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.MenuPrincipal;

public class ControlMenuPrincipal implements ActionListener{
    
    MenuPrincipal mm;
    
    public ControlMenuPrincipal(MenuPrincipal mm){
        this.mm = mm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        if (e.getSource().equals(mm.btnReserva)) {
            ViewNuevo viewNuevo = new ViewNuevo(mm);
            ModelNuevo modelNuevo = new ModelNuevo(viewNuevo);
            ControllerNuevo controllerNuevo = new ControllerNuevo(modelNuevo, viewNuevo);
        }
        if (e.getSource().equals(mm.btnConsultar)) {
            ViewConsultar viewConsultar = new ViewConsultar(mm);
            ModelConsultar modelConsultar = new ModelConsultar();
            ControllerConsultar controllerConsultar = new ControllerConsultar(modelConsultar, viewConsultar);
        }
        if (e.getSource().equals(mm.btnActualizar)) {
            ViewActualizar viewActualizar = new ViewActualizar(mm);
            ModelActualizar modelActualizar = new ModelActualizar(viewActualizar);
            ControllerActualizar controllerActualizar = new ControllerActualizar(modelActualizar, viewActualizar);
        }
        if (e.getSource().equals(mm.btnAcerca)) {
            Acerca ab = new Acerca(mm);
        }
        if (e.getSource().equals(mm.btnListados)) {
            Listados ls = new Listados(mm);
        }
        if (e.getSource().equals(mm.btnEstadisticas)) {
            Estadisticas es = new Estadisticas(mm);
        }*/
    }
}
