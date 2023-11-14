package modelo;

import conexion_base.Conexion;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ModeloGraficoLineas {

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Conexion objConexion = new Conexion();
        boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");

        if (!errorConexion) {
            try {
                Map<String, Map<String, Integer>> data = new HashMap<>();

                // Obtener datos directamente de la base de datos
                String sql = "SELECT * FROM cliente";
                ResultSet rs = objConexion.consulta(sql);

                // Inicializar el conjunto de meses
                Set<String> allMonths = new HashSet<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));

                while (rs.next()) {
                    String checkinString = rs.getString("checkin");
                    String roomType = rs.getString("habitacion");
                    String month = formatDate(checkinString);

                    if (!data.containsKey(roomType)) {
                        data.put(roomType, new HashMap<>());
                    }

                    Map<String, Integer> roomTypeData = data.get(roomType);

                    // Asegurar que todos los meses estén representados, incluso si no hay reservas
                    for (String singleMonth : allMonths) {
                        roomTypeData.put(singleMonth, roomTypeData.getOrDefault(singleMonth, 0));
                    }

                    // Incrementar la cantidad de reservas para el mes actual
                    roomTypeData.put(month, roomTypeData.get(month) + 1);
                }

                for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
                    Map<String, Integer> roomTypeData = entry.getValue();
                    for (Map.Entry<String, Integer> monthData : roomTypeData.entrySet()) {
                        dataset.addValue(monthData.getValue(), entry.getKey(), monthData.getKey());
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                objConexion.desconectar();
            }
        }

        return dataset;
    }

    private String formatDate(String dateString) {
        // Puedes implementar la lógica de formato según sea necesario
        // En este ejemplo, se devuelve el mes en formato MM
        return new SimpleDateFormat("MM").format(new Date(dateString));
    }
}