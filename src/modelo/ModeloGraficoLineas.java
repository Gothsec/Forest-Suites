package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jfree.data.category.DefaultCategoryDataset;

public class ModeloGraficoLineas {

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Map<String, Map<String, Integer>> data = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    Date checkinDate = dateFormat.parse(parts[4].trim());
                    String roomType = parts[2].trim();
                    String month = new SimpleDateFormat("MMMM yyyy").format(checkinDate);

                    if (!data.containsKey(roomType)) {
                        data.put(roomType, new HashMap<>());
                    }

                    Map<String, Integer> roomTypeData = data.get(roomType);
                    roomTypeData.put(month, roomTypeData.getOrDefault(month, 0) + 1);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
            Map<String, Integer> roomTypeData = entry.getValue();
            for (Map.Entry<String, Integer> monthData : roomTypeData.entrySet()) {
                dataset.addValue(monthData.getValue(), entry.getKey(), monthData.getKey());
            }
        }

        return dataset;
    }
}
