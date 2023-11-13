package modelo;

import Utilidades.Utilidades;
import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaActualizar;
import vista.VistaConsulta;

public class ModeloActualizar {
    VistaActualizar obj_vista_actualizar;
    Utilidades obj_utilidades = new Utilidades();
    
    public ModeloActualizar(VistaActualizar objVista){
        obj_vista_actualizar = objVista;
    }

    public void escribirReservacion() {
    
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        String id = obj_vista_actualizar.textfield_id.getText();

                        String datos[] = objConexion.consultaFila("cliente", "id", id);
                        
                        
                        
                        if (datos != null) {
                            
                            if (datos[6].equals("activo")) {
                                int index = 0;

                                if (datos[3].equals("Individual")) {
                                    index = 0;
                                }

                                if (datos[3].equals("Doble")) {
                                    index = 1;
                                }

                                if (datos[3].equals("Matrimonial")) {
                                    index = 2;
                                }

                                if (datos[3].equals("Suite")) {
                                    index = 3;
                                }

                                obj_vista_actualizar.textfield_id.setText(datos[0]);
                                obj_vista_actualizar.textfield_nombre.setText(datos[1]);
                                obj_vista_actualizar.textfield_email.setText(datos[2]);
                                obj_vista_actualizar.combobox_habitacion.setSelectedIndex(index);
                                obj_vista_actualizar.textfield_checkin.setText(datos[4]);
                                obj_vista_actualizar.textfield_checkout.setText(datos[5]);

                                obj_vista_actualizar.textfield_id.setEditable(false);
                                obj_vista_actualizar.textfield_nombre.setEnabled(true);
                                obj_vista_actualizar.textfield_email.setEnabled(true);
                                obj_vista_actualizar.combobox_habitacion.setEnabled(true);
                                obj_vista_actualizar.textfield_checkin.setEnabled(true);
                                obj_vista_actualizar.textfield_checkout.setEnabled(true);

                                obj_vista_actualizar.boton_buscar.setEnabled(false);
                                obj_vista_actualizar.boton_actualizar.setEnabled(true);
                            } else {
                                obj_utilidades.ventanaEmergente("Usuario inactivo");
                                obj_vista_actualizar.textfield_id.setText("");
                            }
                        } else {
                            obj_utilidades.ventanaEmergente("ID no registrado en la base de datos");
                            obj_vista_actualizar.textfield_id.setText("");
                        }
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
                        a.printStackTrace();
                    } finally {
                        objConexion.desconectar();
                    }
                }
    }
    
    public void actualizarReservacion() {
        Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                String nombre = obj_vista_actualizar.textfield_nombre.getText();
                String email = obj_vista_actualizar.textfield_email.getText();
                String habitacion = (String) obj_vista_actualizar.combobox_habitacion.getSelectedItem();
                String checkin = obj_vista_actualizar.textfield_checkin.getText();
                String checkout = obj_vista_actualizar.textfield_checkout.getText();
                int id = Integer.parseInt(obj_vista_actualizar.textfield_id.getText());
                
                String sql = "UPDATE cliente SET "
        + "nombre = '" + nombre + "', "
        + "email = '" + email + "', "
        + "habitacion = '" + habitacion + "', "
        + "checkin = '" + checkin + "', "
        + "checkout = '" + checkout + "' "
        + "WHERE id = '" + id + "'";

                if (!errorConexion) {
                    try {
                        objConexion.actualizar(sql);
                        obj_utilidades.ventanaEmergente("Actualizacion exitosa");
                        
                        obj_vista_actualizar.textfield_nombre.setText("");
                        obj_vista_actualizar.textfield_email.setText("");
                        obj_vista_actualizar.combobox_habitacion.setSelectedIndex(0);
                        obj_vista_actualizar.textfield_checkin.setText("");
                        obj_vista_actualizar.textfield_checkout.setText("");
                        obj_vista_actualizar.textfield_id.setText("");
                        
                        obj_vista_actualizar.textfield_id.setEditable(true);
                            obj_vista_actualizar.textfield_nombre.setEnabled(false);
                            obj_vista_actualizar.textfield_email.setEnabled(false);
                            obj_vista_actualizar.combobox_habitacion.setEnabled(false);
                            obj_vista_actualizar.textfield_checkin.setEnabled(false);
                            obj_vista_actualizar.textfield_checkout.setEnabled(false);
                        
                        obj_vista_actualizar.boton_actualizar.setEnabled(false);
                        obj_vista_actualizar.boton_buscar.setEnabled(true);
                        
                    } catch (Exception b) {
                        JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
                        b.printStackTrace();
                    } finally {
                        objConexion.desconectar();
                    }
        }
    }
}
