/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package controlador;

import conexion_base.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloCrearCliente;
import vista.VistaCrear;
import vista.VistaCrearCliente;
import vista.VistaMenuPrincipal;

public class ControladorCrearCliente {
    
    public ModeloCrearCliente objModelo;
    public VistaCrearCliente objVista;
    public VistaMenuPrincipal obj_menu;
    
    public ControladorCrearCliente (ModeloCrearCliente objModelo, VistaCrearCliente objVista) {
        this.objModelo = objModelo;
        this.objVista = objVista;
        
        objVista.selectCheckin.addActionListener(new SelectCheckinListener());
        objVista.selectCheckout.addActionListener(new SelectCheckoutListener());
        objVista.btnGuardarReserva.addActionListener(new GuardarListener());
        objVista.btnLimpiarReserva.addActionListener(new LimpiarListener());
        objVista.btnVolver.addActionListener(new VolverListener());
    }

    
    class SelectCheckinListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Date selectedDate = objModelo.showDatePicker(objVista.obj_menu);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                objVista.textFieldCheckin.setText(dateFormat.format(selectedDate));
            }
        }
    }
    
    class SelectCheckoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Date selectedDate = objModelo.showDatePicker(objVista.obj_menu);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                objVista.textFieldCheckout.setText(dateFormat.format(selectedDate));
            }
        }
    }
    
    class GuardarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ModeloCrearCliente obj_crear = new ModeloCrearCliente(objVista);
            obj_crear.nuevaReservacion();
        }
    }
    
    class LimpiarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            objVista.textFieldNombre.setText("");
            objVista.textFieldEmail.setText("");
            objVista.textFieldCheckin.setText("");
            objVista.textFieldCheckout.setText("");
        }
    }
    
    class VolverListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaCrear obj_vistacrear = new VistaCrear();
            ControladorCrear obj_controlador_crear = new ControladorCrear(obj_menu, obj_vistacrear);
            objVista.setVisible(false);
            objVista.dispose();
        }
    }
}
