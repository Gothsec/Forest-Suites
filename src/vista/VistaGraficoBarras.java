/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class VistaGraficoBarras extends JFrame {

    JFreeChart chart;
    public ImageIcon icono_volver;
    public JButton boton_volver;

    public VistaGraficoBarras() {
        super("Gráfico de Reservas por Duración de Estadía");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        crearGrafico();

        // Crear un nuevo panel contenedor
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.X_AXIS));

        // Crear el botón de retroceso
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(20, 520, 30, 30);
        add(boton_volver);

        // Ajustar el diseño del panel gráfico
        ChartPanel panel = new ChartPanel(chart, false);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 520));
        panelContenedor.add(panel);

        // Añadir el panel contenedor al JFrame
        add(panelContenedor);

        setVisible(true);
    }

    public void crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Inicializar contadores para cada duración de estadía
        int unoATresDias = 0;
        int cuatroASieteDias = 0;
        int masDeSieteDias = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) { //Pendiente para base de datos
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String checkin = parts[4].trim();
                    String checkout = parts[5].trim();

                    // Calcular la duración de estadía en días
                    int duracion = calcularDuracionEstadia(checkin, checkout);

                    // Incrementar el contador correspondiente
                    if (duracion >= 1 && duracion <= 3) {
                        unoATresDias++;
                    } else if (duracion >= 4 && duracion <= 7) {
                        cuatroASieteDias++;
                    } else {
                        masDeSieteDias++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Agregar los contadores al conjunto de datos
        dataset.addValue(unoATresDias, "Cantidad de Reservas", "1-3 Días");
        dataset.addValue(cuatroASieteDias, "Cantidad de Reservas", "4-7 Días");
        dataset.addValue(masDeSieteDias, "Cantidad de Reservas", "Más de 7 Días");

        // Crear el gráfico de barras
        chart = ChartFactory.createBarChart(
                "Cantidad de Reservas por Duración de Estadía",
                "Duración de Estadía (Días)",
                "Cantidad de Reservas",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    private int calcularDuracionEstadia(String checkin, String checkout) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date fechaCheckin = dateFormat.parse(checkin);
            java.util.Date fechaCheckout = dateFormat.parse(checkout);
            long diferenciaMillis = fechaCheckout.getTime() - fechaCheckin.getTime();
            int diferenciaDias = (int) (diferenciaMillis / (1000 * 60 * 60 * 24));
            return diferenciaDias;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {
        VistaGraficoBarras grafico = new VistaGraficoBarras();
    }
}