/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaListadoFecha;

public class ModeloListadoFecha {
    
    VistaListadoFecha obj_vista;
    
    public ModeloListadoFecha(VistaListadoFecha obj_vista) {
        this.obj_vista = obj_vista;
    }
    
    public void obtenerDatos() {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        
                        String[][] datos = objConexion.consultaMatrizAll("cliente");
                        obj_vista.model.setRowCount(0);
                        
                        String fecha = obj_vista.textfieldFecha.getText();
                        
                    if (obj_vista.tipoFechaCombo.getSelectedIndex() == 0) {

                        for (String[] fila : datos) {
                            if (fila[4].equals(fecha) ) {
                                obj_vista.model.addRow(fila);
                            }
                        }    
                    } else {
                        for (String[] fila : datos) {
                            if (fila[5].equals(fecha) ) {
                                obj_vista.model.addRow(fila);
                            }
                    }
                        
                    
                }
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
                        a.printStackTrace();
                    } finally {
                        objConexion.desconectar();
                    }
                }
    }
}
