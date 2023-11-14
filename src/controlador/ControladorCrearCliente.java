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
    
    
    public VistaCrear obj_vista_crear;
    public ModeloCrearCliente objModelo;
    public VistaCrearCliente objVista;
    public VistaMenuPrincipal obj_menu;
    
    public ControladorCrearCliente (VistaCrear obj_vista_crear, VistaCrearCliente objVista) {
        this.objVista = objVista;
        this.obj_vista_crear = obj_vista_crear;
        
        objVista.selectCheckin.addActionListener(new SelectCheckinListener());
        objVista.selectCheckout.addActionListener(new SelectCheckoutListener());
    
        objVista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_vista_crear.setVisible(true);
                objVista.setVisible(false);
                objVista.dispose();
            }
        });
        
        objVista.btnGuardarReserva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloCrearCliente obj_crear = new ModeloCrearCliente(objVista);
                obj_crear.nuevaReservacion();
            }
        });
        
        objVista.btnLimpiarReserva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                objVista.textFieldNombre.setText("");
                objVista.textFieldEmail.setText("");
                objVista.textFieldCheckin.setText("");
                objVista.textFieldCheckout.setText("");
            }
        });
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
    
    }
    
