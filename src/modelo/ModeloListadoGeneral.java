
package modelo;

import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaListadoGeneral;


public class ModeloListadoGeneral {
    
    VistaListadoGeneral obj_vista;
    
    public ModeloListadoGeneral(VistaListadoGeneral obj_vista) {
        this.obj_vista = obj_vista;
    }
    
    public void obtenerDatos() {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
               
                    String[][] datos = objConexion.consultaMatrizAll("cliente");

                // Agregar filas al modelo de tabla
                for (String[] fila : datos) {
                   obj_vista.model.addRow(fila);
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
