package modelo;

import conexion_base.Conexion;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloGraficoTorta {

    public DefaultPieDataset getData() {
        DefaultPieDataset data = new DefaultPieDataset();
        
        Conexion objConexion = new Conexion();
        boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");

        if (!errorConexion) {
            try {
                String sql = "SELECT * FROM cliente";
                ResultSet rs = objConexion.consulta(sql);

                int contadorSuite = 0;
                int contadorMatrimonial = 0;
                int contadorIndividual = 0;
                int contadorDoble = 0;

                while (rs.next()) {
                    String tipoHabitacion = rs.getString("habitacion");

                    switch (tipoHabitacion) {
                        case "Suite":
                            contadorSuite++;
                            break;
                        case "Matrimonial":
                            contadorMatrimonial++;
                            break;
                        case "Individual":
                            contadorIndividual++;
                            break;
                        case "Doble":
                            contadorDoble++;
                            break;
                    }
                }

                data.setValue("Suite", contadorSuite);
                data.setValue("Matrimonial", contadorMatrimonial);
                data.setValue("Individual", contadorIndividual);
                data.setValue("Doble", contadorDoble);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                objConexion.desconectar();
            }
        }

        return data;
    }
}
