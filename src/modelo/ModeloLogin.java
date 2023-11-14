package modelo;

import com.sun.jdi.connect.spi.Connection;
import conexion_base.Conexion;
import controlador.ControladorLogin;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import vista.VistaLogin;
//



public class ModeloLogin {

    VistaLogin obj_vista;
    
    public ModeloLogin(VistaLogin obj_vista) {
        this.obj_vista = obj_vista;
    }

    public String[] verificar() {
        boolean verificacion = false;
        Conexion conexion = new Conexion();
        boolean errorConexion = conexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");
        String[] fila = null;
        
        try {
            String usuario = obj_vista.campo_login.getText();
            String contrasena = obj_vista.campo_contrasena.getText();
            
            fila = conexion.consultaFila("usuario", "nombre", usuario);
            
            
                    
                    if (fila[0].equals(usuario) && fila[1].equals(contrasena)) {
                        return fila;
                    }
                    

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        
        return null;

    }
}
