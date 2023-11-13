package modelo;

import Utilidades.Utilidades;
import conexion_base.Conexion;
import javax.swing.JOptionPane;
import vista.VistaConsulta;
import vista.VistaCrearCliente;

public class ModeloConsulta {
    
    VistaConsulta obj_vista_consulta;
    Utilidades obj_utilidades = new Utilidades();
    
    public ModeloConsulta(VistaConsulta objVista){
        obj_vista_consulta = objVista;
    }

    public void consultarReservacion() {
    
    Conexion objConexion = new Conexion();
                boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
                
                if (!errorConexion) {
                    try {
                        String id = obj_vista_consulta.textfield_id.getText();

                        String datos[] = objConexion.consultaFila("cliente", "id", id);
                        
                        if (datos != null) {
                            
                            if (datos[6].equals("activo")) {

                                obj_vista_consulta.textfield_id.setText(datos[0]);
                                obj_vista_consulta.textfield_nombre.setText(datos[1]);
                                obj_vista_consulta.textfield_email.setText(datos[2]);
                                obj_vista_consulta.textfield_habitacion.setText(datos[3]);
                                obj_vista_consulta.textfield_checkin.setText(datos[4]);
                                obj_vista_consulta.textfield_checkout.setText(datos[5]);
                                obj_vista_consulta.textfield_id.setEditable(false);
                                obj_vista_consulta.boton_consultar.setEnabled(false);
                                obj_vista_consulta.boton_limpiar.setEnabled(true);
                            } else {
                                obj_utilidades.ventanaEmergente("Usuario inactivo");
                                obj_vista_consulta.textfield_id.setText("");
                            }
                        } else {
                            obj_utilidades.ventanaEmergente("ID no registrado en la base de datos");
                            obj_vista_consulta.textfield_id.setText("");
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

                                                                                                /*
                                                                                                    ¿por que USA perdió el mundial de ajedrez?
                                                                                                    por que le faltaba las torres
                                                                                                */