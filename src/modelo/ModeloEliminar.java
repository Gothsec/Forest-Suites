package modelo;

import Utilidades.Utilidades;
import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaEliminar;

public class ModeloEliminar {
    
    VistaEliminar obj_vista_eliminar;
    Utilidades obj_utilidades = new Utilidades();
    
    public ModeloEliminar (VistaEliminar obj_vista_eliminar) {
        this.obj_vista_eliminar = obj_vista_eliminar;
    }
    
    public void escribirReservacion() {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        String id = obj_vista_eliminar.textfield_id.getText();

                        String datos[] = objConexion.consultaFila("cliente", "id", id);
                        
                        if (datos != null) {
                            
                            if (datos[6].equals("activo")) {

                            obj_vista_eliminar.textfield_id.setText(datos[0]);
                            obj_vista_eliminar.textfield_nombre.setText(datos[1]);
                            obj_vista_eliminar.textfield_email.setText(datos[2]);
                            obj_vista_eliminar.textfield_habitacion.setText(datos[3]);
                            obj_vista_eliminar.textfield_checkin.setText(datos[4]);
                            obj_vista_eliminar.textfield_checkout.setText(datos[5]);
                                obj_vista_eliminar.textfield_id.setEditable(false);
                                obj_vista_eliminar.boton_buscar.setEnabled(false);
                                obj_vista_eliminar.boton_eliminar.setEnabled(true);
                            } else {
                                obj_utilidades.ventanaEmergente("Usuario inactivo");
                            }
                        } else {
                            obj_utilidades.ventanaEmergente("ID no registrado en la base de datos");
                            obj_vista_eliminar.textfield_id.setText("");
                        }
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
                        a.printStackTrace();
                    } finally {
                        objConexion.desconectar();
                    }
                }
    }
    
    public void EliminarReservacion () {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        
                        String id = obj_vista_eliminar.textfield_id.getText();
                        String sql = "UPDATE cliente SET estado = 'inactivo' WHERE id = '" + id + "'";
                        objConexion.actualizar(sql);
                        
                        obj_utilidades.ventanaEmergente("Eliminacion exitosa");
                        
                        obj_vista_eliminar.textfield_nombre.setText("");
                        obj_vista_eliminar.textfield_email.setText("");
                        obj_vista_eliminar.textfield_habitacion.setText("");
                        obj_vista_eliminar.textfield_checkin.setText("");
                        obj_vista_eliminar.textfield_checkout.setText("");
                        obj_vista_eliminar.textfield_id.setText("");
                        
                        obj_vista_eliminar.textfield_id.setEditable(true);
                        
                        obj_vista_eliminar.boton_eliminar.setEnabled(false);
                        obj_vista_eliminar.boton_buscar.setEnabled(true);

                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
                        a.printStackTrace();
                    } finally {
                        objConexion.desconectar();
                    }
                }
    }
}
