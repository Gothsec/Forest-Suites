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
import vista.VistaCrearUsuario;



public class ModeloCrearUsuario {
    
    VistaCrearUsuario objVista;
    
    public ModeloCrearUsuario(VistaCrearUsuario objVista){
        this.objVista = objVista;
    }
    
    public void nuevoUsuario() {
        Conexion con = new Conexion();
        boolean errorConexion = con.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");

        if (!errorConexion) {
            String nombre = objVista.textfield_nombre.getText();
            String contraseña = objVista.textfield_contraseña.getText();
            String tipo = objVista.comboBoxTipo.getSelectedItem().toString();

        try {
            String[] datos = { nombre, contraseña, tipo };
            boolean errorGuardado = con.insertar("usuario", datos);

            if (!errorGuardado) {
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                objVista.textfield_nombre.setText("");
                objVista.textfield_contraseña.setText("");
                objVista.comboBoxTipo.setSelectedIndex(0);
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