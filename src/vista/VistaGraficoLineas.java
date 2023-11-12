/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VistaGraficoLineas extends JFrame {

    public VistaGraficoLineas() {
        super("Gráfico de Líneas");
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        add(chartPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Configura el cierre solo para la ventana actual

        pack();
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Esto se ejecuta cuando se cierra la ventana
                super.windowClosed(e);
                System.out.println("Ventana cerrada.");
            }
        });
    }

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Map<String, Map<String, Integer>> data = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) { //Pendiente para base de datos
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

    public JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Reservas de Habitaciones por Mes",
                "Mes",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = new LineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaGraficoLineas chart = new VistaGraficoLineas();
            chart.setVisible(true);
        });
    }
}