/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package modelo;

import conexion_base.Conexion;
import controlador.ControladorCrear;
import controlador.ControladorCrearCliente;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import vista.VistaCrear;
import vista.VistaCrearCliente;
import java.sql.SQLException;



public class ModeloCrearCliente {
    
    VistaCrearCliente objVista;
    private static int contadorid = 0;
    private int id;
    
    public ModeloCrearCliente(VistaCrearCliente objVista){
        this.objVista = objVista;
    }
    
    public static Date showDatePicker(Component parent) {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);

        int option = JOptionPane.showOptionDialog(parent, spinner, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            return (Date) spinner.getValue();
        }

        return null;
    }
    
    public void nuevaReservacion() {
        Conexion con = new Conexion();
        boolean errorConexion = con.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");

        if (!errorConexion) {
            int id = ++contadorid;
            //String str_id = id + "";
            //objVista.textFieldId.setText(str_id);
            String nombre = objVista.textFieldNombre.getText();
            String correo = objVista.textFieldEmail.getText();
            String habitacion = objVista.comboBoxHabitacion.getSelectedItem().toString();
            String checkin = objVista.textFieldCheckin.getText();
            String checkout = objVista.textFieldCheckout.getText();

        try {
            
            String[] datos = { String.valueOf(id), nombre, correo, habitacion, checkin, checkout, "activo" };
            boolean errorGuardado = con.insertar("cliente", datos);

            if (!errorGuardado) {
                JOptionPane.showMessageDialog(null, "Reservación guardada exitosamente");
                objVista.textFieldId.setText("");
                objVista.textFieldNombre.setText("");
                objVista.textFieldEmail.setText("");
                objVista.comboBoxHabitacion.setSelectedIndex(0);
                objVista.textFieldCheckin.setText("");
                        objVista.textFieldCheckout.setText("");
            }

        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
            e.printStackTrace();
        } finally {
            con.desconectar();
        }
    }
}

}