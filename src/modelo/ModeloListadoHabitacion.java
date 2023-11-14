
package modelo;

import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaListadoGeneral;
import vista.VistaListadoHabitacion;


public class ModeloListadoHabitacion {
    
    VistaListadoHabitacion obj_vista;
    
    public ModeloListadoHabitacion(VistaListadoHabitacion obj_vista) {
        this.obj_vista = obj_vista;
    }
    
    public void obtenerDatos() {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        
                        String[][] datos = objConexion.consultaMatrizAll("cliente");
                        obj_vista.model.setRowCount(0);

                // Agregar filas al modelo de tabla
                for (String[] fila : datos) {
                    if (fila[3].equals(obj_vista.comboBox.getSelectedItem())) {
                        obj_vista.model.addRow(fila);
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

