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
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

public class VistaGraficoTorta extends JFrame {

    JFreeChart chart;

    public VistaGraficoTorta() {
        super("Gráfico de Tipos de Habitación ocupadas");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {
        DefaultPieDataset data = new DefaultPieDataset();
        int contadorSuite = 0;
        int contadorMatrimonial = 0;
        int contadorIndividual = 0;
        int contadorDoble = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) { //pendiente para base de datos
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String tipoHabitacion = parts[2].trim();
                    // Incrementar el contador para el tipo de habitación
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        data.setValue("Suite", contadorSuite);
        data.setValue("Matrimonial", contadorMatrimonial);
        data.setValue("Individual", contadorIndividual);
        data.setValue("Doble", contadorDoble);

        chart = ChartFactory.createPieChart(
                "Cantidad de tipos de habitación ocupadas",
                data,
                true,
                true,
                false
        );

        // Personalizacion
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        chart.getTitle().setPaint(Color.DARK_GRAY);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})",  // Formato: {0} es la clave (nombre), {1} es el valor, {2} es el porcentaje
            new java.text.DecimalFormat("0"),  // Formato del valor
            new java.text.DecimalFormat("0.00%") // Formato del porcentaje
        );
        plot.setLabelGenerator(labelGenerator);
    }

    public static void main(String[] args) {
        VistaGraficoTorta torta = new VistaGraficoTorta();
    }
}