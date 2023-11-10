/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package modelo;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import vista.VistaCrearCliente;


public class ModeloCrearCliente {
    
    VistaCrearCliente objVista;
    
    public ModeloCrearCliente(VistaCrearCliente objVista){
        this.objVista = objVista;
    }
    
    int lastGeneratedId = contarReservaciones();
    
    public int generateNextId() {
        return ++lastGeneratedId; // Incrementar y devolver el ID siguiente
    }
    
    public int contarReservaciones() {
        FileReader file = null;
        int numero = 0;
        
        try {
            
            file = new FileReader("datos.csv");
        
        } catch (IOException e) {
            
            return numero;
        
        }
        
        BufferedReader lectura = new BufferedReader(file);
        String fila = "";
            
        try {
                
            while((fila = lectura.readLine()) != null) {
                numero++;
            }
                
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "Error");
        
        }
            
        
        return numero;
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

        FileWriter archivo = null;
        boolean error = false;
        
        
        try {
            archivo = new FileWriter("datos.csv", true);
        } catch (IOException e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo 'datos.csv'");
        }
        
        if (!error) {
            
            String nombre = objVista.textFieldNombre.getText();
            String correo = objVista.textFieldEmail.getText();
            String habitacion = objVista.comboBoxHabitacion.getSelectedItem().toString();
            String checkIn = objVista.textFieldCheckin.getText();
            String checkOut = objVista.textFieldCheckout.getText();

            // Obtener el ID del TextField
            int id = Integer.parseInt(objVista.textFieldId.getText());
            
            try {
                archivo.write(id + ";" + nombre + ";" + habitacion + ";" + correo + ";" + checkIn + ";" + checkOut + "\r\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de guardar el archivo");
            }
            
            try {
                archivo.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de cerrar el archivo");
            }
        }
    }
}